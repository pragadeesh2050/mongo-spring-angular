package com.experiment.mongoexample.mapper;


import com.experiment.mongoexample.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User MapDtoToUser(User userDto, User user){
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCountry(userDto.getCountry());
        user.setState(userDto.getState());
        user.setCity(userDto.getCity());
        user.setAddress(userDto.getAddress());
        user.setZipCode(userDto.getZipCode());

        return user;
    }
}
