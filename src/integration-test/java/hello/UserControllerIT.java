package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import hello.User;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIT {
    @LocalServerPort
    private int port;
    
    private URL base;
    
    @Autowired
    private TestRestTemplate template;
    
    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }
    
    @Test
    public void getHello() throws Exception {
        String url = base.toString() + "/user/new";
        ResponseEntity<User> responseEntity = template.getForEntity(url, User.class);
        User user = responseEntity.getBody();
        assertThat(user.getName(), equalTo("John"));
    }
}

