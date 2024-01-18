package websocket.service;

import websocket.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();
    User updateUser(Integer userId, User updatedUser);
    void deleteUser(Integer userId);

    Optional<User> getUserById(Integer id);
}
