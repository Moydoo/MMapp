package MieszkoEnterprices.MM;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void index() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @ParameterizedTest
    @CsvSource({
            "Kajak",
            "Majka",
            "Szajka",
            "Kupka"
    })
    void home(String input) throws Exception {
        mvc.perform(get("/home?input=" + input).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("What I mean is: " + input)));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 10, 15",
            "3, 3, 6",
            "-1, -2, -3",
            "0, 0, 0",
            "87, 33, 120",
            "-78, 18, -60"
    })
    void sum(int a, int b, int expectedResult) throws Exception {
        mvc.perform(get("/sum?a=" + a + "&b=" + b).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("The sum is: " + expectedResult)));
    }
}