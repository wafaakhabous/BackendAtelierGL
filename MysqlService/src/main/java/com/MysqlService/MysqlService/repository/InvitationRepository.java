package com.MysqlService.MysqlService.repository;
import com.MysqlService.MysqlService.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    List<Invitation> findByUserReceiver(Long userReceiver);
}