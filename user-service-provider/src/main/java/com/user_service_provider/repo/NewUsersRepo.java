package com.user_service_provider.repo;

import com.user_service_provider.entity.NewUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewUsersRepo extends JpaRepository<NewUsers, Long> {
    List<NewUsers> findByNameAndAge(String name, int age);
}
