package dev.Ashutosh.Splitwise.mapper;

import dev.Ashutosh.Splitwise.dto.UserSignUpDTO;
import dev.Ashutosh.Splitwise.models.User;

public class UserEntityDTOMapper {

    public static User dtoToEntity(UserSignUpDTO userSignUpDTO){
        User user = new User();
        user.setUsername(userSignUpDTO.getUserName());
        user.setPassword(userSignUpDTO.getPassword());
        user.setEmail(userSignUpDTO.getEmail());
        return user;
    }

}
