package ar.edu.itba.paw.interfaces.service;

import ar.edu.itba.paw.models.User;

import java.util.Optional;

public interface UserService {
    User findById(int id);
    Optional<User> findByEmail(String email);
    User create(String email, String firstName, String lastName, int age, String password);
}
