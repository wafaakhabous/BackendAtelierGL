package com.example.Users.repository;

import com.example.Users.model.TravelCompanionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelCompanionRequestRepository extends JpaRepository<TravelCompanionRequest, Long> {
    // You can add custom query methods if needed
}
