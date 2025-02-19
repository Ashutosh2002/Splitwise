package dev.Ashutosh.Splitwise.services;

import dev.Ashutosh.Splitwise.dto.UserSignUpDTO;
import dev.Ashutosh.Splitwise.exceptions.UserNotFoundException;
import dev.Ashutosh.Splitwise.models.User;
import dev.Ashutosh.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found")
        );
    }

}
