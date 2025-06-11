package com.user_service_provider.service;

import com.user_service_provider.entity.Users;
import com.user_service_provider.exception.UserNotFoundException;
import com.user_service_provider.repo.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepo  userRepository;

    public Users saveUser(Users user){
        return userRepository.save(user);
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
    }

    public Users updateUser(Long id, Users user){
        Users existringUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
        existringUser.setName(user.getName());
        existringUser.setEmail(user.getEmail());
        return userRepository.save(existringUser);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }


}

