package com.bus.repository;

import com.bus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

    public User findByContact(Long contactNo);
}
