package com.bus.Repository;

import com.bus.Model.CurrentSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<CurrentSession, Integer> {

    CurrentSession findByUuid(String uuid);
}
