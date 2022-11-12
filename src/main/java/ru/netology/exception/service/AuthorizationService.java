package ru.netology.exception.service;

import org.springframework.stereotype.Service;
import ru.netology.exception.exceptions.InvalidCredentials;
import ru.netology.exception.exceptions.UnauthorizedUser;
import ru.netology.exception.model.Authorities;
import ru.netology.exception.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<Authorities> str) {
        return str == null || str.isEmpty();
    }
}
