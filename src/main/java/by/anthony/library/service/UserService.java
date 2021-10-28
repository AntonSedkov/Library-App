package by.anthony.library.service;

import by.anthony.library.model.User;

public interface UserService {

    Iterable<User> findAllUsers();

    User findUserById(long id);

    User createUser(User user);

    User updateUser(User user, long id);

    void deleteUser(long id);

}
