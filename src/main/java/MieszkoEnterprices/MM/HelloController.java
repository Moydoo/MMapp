package MieszkoEnterprices.MM;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("home")
    public String home(@RequestParam String input) {
        return "What I mean is: " + input;
    }

    @GetMapping("sum")
    public String sum(@RequestParam int a, @RequestParam int b) {
        return "The sum is: " + (a + b);
    }

    @GetMapping("users")
    public ResponseEntity<Object> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }


}