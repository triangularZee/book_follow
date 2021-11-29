package hello_world.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controller {
    @GetMapping("/test")
    public String test(){
        return "hello world";
    }

}
