package com.koc.finalproject.repository;

import com.koc.finalproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
    User findByPhone(String phone);
    boolean existsByPhone(String phone);
    List<User> findAll();
    void deleteById(Integer id);
}

