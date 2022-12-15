package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.model.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

}
