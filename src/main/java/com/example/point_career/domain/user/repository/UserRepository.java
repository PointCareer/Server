package com.example.point_career.domain.user.repository;

import com.example.point_career.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        Optional<User> findByLoginId(String loginId);
        Optional<User> findByEmail(String email);

        boolean existsByEmail(String email);

        boolean existsByLoginId(String loginId);
}
