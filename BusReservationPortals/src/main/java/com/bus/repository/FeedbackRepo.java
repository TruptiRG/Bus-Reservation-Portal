package com.bus.repository;

import com.bus.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

}
