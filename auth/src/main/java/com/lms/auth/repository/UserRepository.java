package com.lms.auth.repository;

import com.lms.auth.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserByEmail(String username);
}
