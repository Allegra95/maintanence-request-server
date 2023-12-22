package com.codedifferently.maintanencerequestserver.services;

import com.codedifferently.maintanencerequestserver.exceptions.ResourceCreationException;
import com.codedifferently.maintanencerequestserver.exceptions.ResourceNotFoundException;
import com.codedifferently.maintanencerequestserver.models.MaintanenceRequest;
import com.codedifferently.maintanencerequestserver.repos.MaintanenceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MaintanenceRequestServiceImpl {

    @Service
    public class MaintanenceRequestImpl extends MaintanenceRequestService {
        private MaintanenceRequestRepository maintanenceRequestRepository;

        @Autowired
        public void MaintanenceRequestServiceImpl(MaintanenceRequestRepository maintanenceRequestRepository) {
            this.maintanenceRequestRepository = maintanenceRequestRepository;
        }

        @Override
        public MaintanenceRequest create(MaintanenceRequest maintanenceRequest) throws ResourceCreationException {
            Optional<MaintanenceRequest> optional = maintanenceRequestRepository.findByEmail(maintanenceRequest.getEmail());
            if(optional.isPresent())
                throw new ResourceCreationException("Tenant with email exists: " + maintanenceRequest.getEmail());
            maintanenceRequest = maintanenceRequestRepository.save(maintanenceRequest);
            return maintanenceRequest;
        }

        @Override
        public MaintanenceRequest getById(Long id) throws ResourceNotFoundException {
            MaintanenceRequest maintanenceRequest = maintanenceRequestRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("No Tenant with id: " + id));
            return maintanenceRequest;
        }

        @Override
        public MaintanenceRequest getByEmail(String email) throws ResourceNotFoundException {
            MaintanenceRequest maintanenceRequest = maintanenceRequestRepository.findByEmail(email)
                    .orElseThrow(()->new ResourceNotFoundException("No Tenant with email: " + email));
            return maintanenceRequest;
        }

        @Override
        public List<MaintanenceRequest> getAll() {
            return maintanenceRequestRepository.findAll();
        }

        @Override
        public MaintanenceRequest update(Long id, MaintanenceRequest employeeDetail) throws ResourceNotFoundException {
            MaintanenceRequest maintanenceRequest = getById(id);
            MaintanenceRequest maintanenceRequestDetail = new MaintanenceRequest();
            maintanenceRequest.getClass(maintanenceRequestDetail.getFirstName());
            Object maintanenceRequesteDetail = null;
            maintanenceRequest.setLastName(String.valueOf(maintanenceRequesteDetail.getClass()));
            maintanenceRequest.setEmail(maintanenceRequestDetail.getEmail());
            maintanenceRequest = maintanenceRequestRepository.save(maintanenceRequest);
            return maintanenceRequest;
        }

        @Override
        public void delete(Long id) throws ResourceNotFoundException {
            MaintanenceRequest maintanenceRequest = getById(id);
            maintanenceRequestRepository.delete(maintanenceRequest);
        }
    }

}
