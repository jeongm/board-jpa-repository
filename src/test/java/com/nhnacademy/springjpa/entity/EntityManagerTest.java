package entity;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class EntityManagerTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void test(){
        User user0 = User.builder()
                .userId("user0")
                .password("user0")
                .age(22)
                .name("user0name")
                .build();

        entityManager.persist(user0);
        entityManager.flush();

        User user2 = entityManager.find(User.class, "user0");

        assertThat(user2).isEqualTo(user0);
    }

    @Test
    public void test2(){
        Post post1 = entityManager.find(Post.class,1L);

        entityManager.persist(post1);

        Post post2 = entityManager.find(Post.class,1L);
        assertThat(post2).isEqualTo(post1);

//        post2.setContent("bbb");
        entityManager.flush();
    }

}
