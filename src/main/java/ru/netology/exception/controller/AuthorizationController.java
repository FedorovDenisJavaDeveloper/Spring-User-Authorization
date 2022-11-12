package ru.netology.exception.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.exception.model.Authorities;
import ru.netology.exception.model.User;
import ru.netology.exception.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    //    @GetMapping("authorize")
//    public List<Authorities> getAuthorities(
//            @RequestParam("user") String user,
//            @RequestParam("password") String password) {
//        return service.getAuthorities(user, password);
//    }
    @GetMapping("authorize")
    public List<Authorities> getAuthorities(
            @Valid User user) {
        return service.getAuthorities(user);
    }
}
