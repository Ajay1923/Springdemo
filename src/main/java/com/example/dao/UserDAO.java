package com.example.css;

import org.springframework.data.repository.CrudRepository;

import com.example.model.User;

public interface UserDAO extends CrudRepository<User, Integer>{



}
