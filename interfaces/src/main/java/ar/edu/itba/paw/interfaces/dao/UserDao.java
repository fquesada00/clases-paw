package ar.edu.itba.paw.interfaces.dao;

import ar.edu.itba.paw.models.User;

public interface UserDao {
    User findById(int id);
    User create(String email, String firstName, String lastName, int age);
}
