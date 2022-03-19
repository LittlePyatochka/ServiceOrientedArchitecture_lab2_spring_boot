package kamysh.controller;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/state")
public class StateController {

    @SneakyThrows
    @GetMapping
    public String get() {
        return "OK";
    }

}
