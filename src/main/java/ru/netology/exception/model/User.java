package ru.netology.exception.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    @NotBlank(message = "User name is empty!")
    @Size(min = 2,max = 20, message = "User name too short or too long!")
    private String user;
    @NotBlank(message = "User password is empty")
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
