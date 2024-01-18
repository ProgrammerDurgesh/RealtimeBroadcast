package websocket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class HomeRestController {
    @GetMapping
    public String test()
    {
        return "Tested ok  ";
    }
}
