package com.user_service_provider.service;

import com.user_service_provider.entity.NewUsers;
import com.user_service_provider.repo.NewUsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewUserService {

    private final NewUsersRepo userRepository;

    public NewUsers createUser(NewUsers user) {
        return userRepository.save(user);
    }

    public Optional<NewUsers> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<NewUsers> searchUser(String name, int age) {
        return userRepository.findByNameAndAge(name, age);
    }

    public NewUsers updateUser(Long id, NewUsers userRequest) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userRequest.getName());
                    user.setAge(userRequest.getAge());
                    user.setEmail(userRequest.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
