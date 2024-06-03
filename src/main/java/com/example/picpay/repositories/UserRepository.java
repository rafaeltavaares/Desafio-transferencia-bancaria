package com.example.picpay.repositories;

import com.example.picpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByDocument(String document);

    Optional<User> findUserById(Long id);


}
