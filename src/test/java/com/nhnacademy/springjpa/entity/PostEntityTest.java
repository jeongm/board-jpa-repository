package entity;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class PostEntityTest {
    @PersistenceContext
    private EntityManager entityManager;

//    @Test
//    public void testPostEntity(){
//        Post post = entityManager.find(Post.class,1L);
//        assertThat(post.getId().longValue()).isEqualTo(1L);
//    }

    @Test
    public void testPostEntity(){
        Post post = new Post(null,"a","a", LocalDateTime.now(),null);
        entityManager.persist(post);
        entityManager.flush();
        Post post1 = entityManager.find(Post.class, post.getId());
        System.out.println(post1.getId());
    }

}