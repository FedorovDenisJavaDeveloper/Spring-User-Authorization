package ru.netology.exception.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.exception.model.Authorities;
import ru.netology.exception.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("authorize")
    public List<Authorities> getAuthorities(
            @RequestParam("user") String user,
            @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
