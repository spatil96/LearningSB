package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
@ResponseBody
public class HelloWorldController
{
    @GetMapping({ "/helloWorld" })
    public String HelloWorld() {
        return "Hello From First SpringBoot Application";
    }
}