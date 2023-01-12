package ru.netology.exception.service;

import org.springframework.stereotype.Service;
import ru.netology.exception.exceptions.UnauthorizedUser;
import ru.netology.exception.model.Authorities;
import ru.netology.exception.model.User;
import ru.netology.exception.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }


    private boolean isEmpty(List<Authorities> str) {
        return str == null || str.isEmpty();
    }
}
