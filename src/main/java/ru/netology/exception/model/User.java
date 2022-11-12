package ru.netology.exception.model;

import java.util.Objects;

public class User {
    private String user;
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return getUser().equals(user1.getUser()) && getPassword().equals(user1.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getPassword());
    }
}
