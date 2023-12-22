package com.codedifferently.maintanencerequestserver.services;

import com.codedifferently.maintanencerequestserver.exceptions.ResourceCreationException;
import com.codedifferently.maintanencerequestserver.exceptions.ResourceNotFoundException;
import com.codedifferently.maintanencerequestserver.models.MaintanenceRequest;

import java.util.List;

public abstract class MaintanenceRequestService {
    public MaintanenceRequest create(MaintanenceRequest maintanenceRequest) throws ResourceCreationException {
        return null;
    }

    public MaintanenceRequest getById(Long id) throws ResourceNotFoundException {
        return null;
    }

    MaintanenceRequest getByAptNumber(String aptNumber) throws ResourceNotFoundException {
        return null;
    }

    MaintanenceRequest getByDescription(String description throws ResourceNotFoundException {
        return null;
    }

    public abstract MaintanenceRequest getByEmail(String email) throws ResourceNotFoundException;

    public abstract List<MaintanenceRequest> getAll();

    public MaintanenceRequest update(Long id, MaintanenceRequest maintanenceRequestDetail) throws ResourceNotFoundException {

    }

    public void delete(Long id) throws ResourceNotFoundException {
    }
}
