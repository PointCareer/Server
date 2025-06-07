package com.example.point_career.domain.user.repository;

import com.example.point_career.domain.user.entity.EmailCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailCodeRepository extends CrudRepository<EmailCode, String> {
}
