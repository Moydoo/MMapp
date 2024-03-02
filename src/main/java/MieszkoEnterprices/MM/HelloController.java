package MieszkoEnterprices.MM;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/home")
    public String home(@RequestParam String input) {
        return "What I mean is: " + input;
    }

    @GetMapping("/sum")
    public String sum(@RequestParam int a, @RequestParam int b) {
        return "The sum is: " + (a + b);
    }
}