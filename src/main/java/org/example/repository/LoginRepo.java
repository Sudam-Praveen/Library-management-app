package org.example.repository;

import org.example.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  LoginRepo extends JpaRepository<LoginEntity,Long> {
}