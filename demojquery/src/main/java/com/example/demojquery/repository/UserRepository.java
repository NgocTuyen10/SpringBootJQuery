package com.example.demojquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demojquery.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
