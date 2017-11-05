package pl.kodolamacz.spring;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by acacko on 28.10.17
 */

//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
//@Transactional
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserDao userDao;

    private User user;

    @Before
    public void init() {
        user = new User("email@pl", "pass");
        userDao.save(user);
        // tutaj inicjujemy start testów (kontekst testu)
    }


    @Test
    public void simpleFindTest() {
        assertThat(userDao.findAll()).isNotEmpty();
    }

    @Test
    public void findByEmailTest() {
        assertThat(userDao.findByEmail("email@pl")).isNotNull();
        assertThat(userDao.findByEmail("email@pl").getEmail()).isEqualTo("email@pl");
    }

    @Test
    public void findUserByEmail() {
        assertThat(userDao.findByPaaasword("pass")).isNotNull();
    }

    @Test
    public void findUserByNotExistingEmail() {
        assertThat(userDao.findByEmail("xxxx")).isNull();
    }




}
