package dev.Ashutosh.Splitwise.controller;

import dev.Ashutosh.Splitwise.dto.UserSignUpDTO;
import dev.Ashutosh.Splitwise.mapper.UserEntityDTOMapper;
import dev.Ashutosh.Splitwise.models.User;
import dev.Ashutosh.Splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity createUser (@RequestBody UserSignUpDTO userSignUpDTO){
        User newUser = UserEntityDTOMapper.dtoToEntity(userSignUpDTO);
        newUser = userService.createUser(newUser);
        return ResponseEntity.ok(newUser);
    }

    private void signupValidations(UserSignUpDTO userSignUpDTO){
        // add validations
    }
}
