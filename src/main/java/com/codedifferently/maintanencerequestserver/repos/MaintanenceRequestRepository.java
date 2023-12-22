package com.codedifferently.maintanencerequestserver.repos;

import com.codedifferently.maintanencerequestserver.models.MaintanenceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintanenceRequestRepository extends JpaRepository<MaintanenceRequest, Long> {
    Optional<MaintanenceRequest> findByEmail(String email);
}