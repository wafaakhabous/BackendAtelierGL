package com.MysqlService.MysqlService.service;

import com.MysqlService.MysqlService.model.TravelCompanionRequest;
import com.MysqlService.MysqlService.repository.TravelCompanionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelCompanionRequestService {

    @Autowired
    private TravelCompanionRequestRepository requestRepository;

    public List<TravelCompanionRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public TravelCompanionRequest createRequest(TravelCompanionRequest request) {
        // Implement logic to save the request
        return requestRepository.save(request);
    }

    // Add other methods as needed
}
