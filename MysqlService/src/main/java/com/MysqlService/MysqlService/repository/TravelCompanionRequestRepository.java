package com.MysqlService.MysqlService.repository;

import com.MysqlService.MysqlService.model.TravelCompanionRequest;
import com.MysqlService.MysqlService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelCompanionRequestRepository extends JpaRepository<TravelCompanionRequest, Long> {
    Optional<TravelCompanionRequest> findById(long id);
}
