package websocket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import websocket.entity.User;
import websocket.repo.UserRepo;
import websocket.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(Integer userId, User updatedUser) {
        Optional<User> existingUser = userRepo.findById(userId);

        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setName(updatedUser.getName());
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setPassword(updatedUser.getPassword());

            return userRepo.save(userToUpdate);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepo.findById(id);
    }
}
