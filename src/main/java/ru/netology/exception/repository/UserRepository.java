package ru.netology.exception.repository;

import org.springframework.stereotype.Repository;
import ru.netology.exception.model.Authorities;
import ru.netology.exception.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    ConcurrentHashMap<User, List<Authorities>> userAuthorities;

    public UserRepository() {
        userAuthorities = new ConcurrentHashMap<>();
        userAuthorities.put(new User("Petya", "0001"), List.of(Authorities.READ));
        userAuthorities.put(new User("Vasya", "0002"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
    }

    public List<Authorities> getUserAuthorities(User user) {
//        final var tryUser = new User(user, password);
        return userAuthorities.getOrDefault(user, null);
    }
}
