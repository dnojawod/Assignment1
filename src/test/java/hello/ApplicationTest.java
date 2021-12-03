package hello;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/index.html")).andExpect(content().string(containsString("Get your greeting")));
    }

    @Test
    public void greeting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting")).andExpect(content().string(containsString("Hello, World!")));
    }

    @Test
    public void greetingWithUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting").param("name", "Greg")).andExpect(content().string(containsString("Hello, Greg!")));
    }
}