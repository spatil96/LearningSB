package springbootrestapi.rf2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
    @GetMapping({ "/helloWorld" })
    public String HelloWorld() {
        return "Hello From First SpringBoot Application";
    }
}