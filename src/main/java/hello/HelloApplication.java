package hello;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(HelloConfiguration.class)
public class HelloApplication {

    @Autowired
    private SomeTestConfig config;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HelloApplication.class, args);
        System.out.println(System.getenv().get("test.other"));
    }

}