package com.bus.repository;

import com.bus.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<CurrentUserSession, Integer> {
}
