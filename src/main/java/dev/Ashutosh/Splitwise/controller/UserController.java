package dev.Ashutosh.Splitwise.controller;

import dev.Ashutosh.Splitwise.dto.UserSignUpDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseEntity createUser (@RequestBody UserSignUpDTO userSignUpDTO){

    }

    private void signupValidations(UserSignUpDTO userSignUpDTO){
        // add validations
    }
}
