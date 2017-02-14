package hello;


import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final SomeTestConfig config;

    @Autowired
    public HelloController(SomeTestConfig config) {
        this.config = config;
    }

    @RequestMapping("/")
    @Timed
    public String index() {
        return config.getValue() + " - " + config.getOther();
    }
}