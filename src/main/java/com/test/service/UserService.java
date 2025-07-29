package com.test.service;

import com.test.model.UserModel;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For demonstration purposes, we are using a hardcoded user.
        if ("victorio".equals(username)) {
            return new User("victorio", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            // Fetch user from the repository, assuming username is the email
            Optional<UserModel> user = userRepository.findByEmail(username);
            if (user.isPresent()) {
                UserModel userModel = user.get();
                return new User(userModel.getEmail(), userModel.getPassword(),
                        new ArrayList<>());
            }

            // If user not found, throw an exception
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public Optional<UserModel> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public String hashPassword(String password) {
        // BCrypt hash
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(password);
    }
}
