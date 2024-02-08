package com.example.Users.client;
import com.example.Users.model.Invitation;
import com.example.Users.model.TravelCompanionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name = "Data-service-inv",  url = "${application.config.DataInv-url}")
public interface DataInv {
    @PostMapping("/inv/Add")
    Invitation save(@RequestBody Invitation user);

    @GetMapping("/inv/All")
    List<Invitation> findAll();

    @GetMapping("/inv/{receiverId}")
    List<Invitation> getInvitationsByReceiver(@PathVariable Long receiverId);

}
