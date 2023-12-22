package com.codedifferently.maintanencerequestserver.controllers;

import com.codedifferently.maintanencerequestserver.exceptions.ResourceCreationException;
import com.codedifferently.maintanencerequestserver.exceptions.ResourceNotFoundException;
import com.codedifferently.maintanencerequestserver.models.MaintanenceRequest;
import com.codedifferently.maintanencerequestserver.services.MaintanenceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MaintanenceRequestController {

    private MaintanenceRequestService maintanenceRequestService;

        @Autowired
        public MaintanenceRequestController(MaintanenceRequestService maintanenceRequestService) {
            this.maintanenceRequestService = maintanenceRequestService;
        }

        @GetMapping
        public ResponseEntity<List<MaintanenceRequest>> getAll(){
            List<MaintanenceRequest> maintanenceRequest = maintanenceRequestService.getAll();
            return new ResponseEntity<>(maintanenceRequest, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<MaintanenceRequest> create(@RequestBody MaintanenceRequest maintanenceRequest) throws ResourceCreationException {
            maintanenceRequest = maintanenceRequestService.create(maintanenceRequest);
            return new ResponseEntity<>(maintanenceRequest, HttpStatus.CREATED);
        }

        @GetMapping("{id}")
        public ResponseEntity<MaintanenceRequest> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
            MaintanenceRequest maintanenceRequest = maintanenceRequestService.getById(id);
            return new ResponseEntity<>(maintanenceRequest, HttpStatus.OK);
        }

        @GetMapping("lookup")
        public ResponseEntity<MaintanenceRequest> getByEmail(@RequestParam String email){
            MaintanenceRequest maintanenceRequest = MaintanenceRequestService.getByEmail(email);
            return new ResponseEntity<>(maintanenceRequest, HttpStatus.OK);
        }

        @PutMapping("{id}")
        public ResponseEntity<MaintanenceRequest> update(@PathVariable("id") Long id, @RequestBody MaintanenceRequest maintanenceRequestDetail) throws ResourceNotFoundException {
            maintanenceRequestDetail = maintanenceRequestService.update(id, maintanenceRequestDetail);
            return new ResponseEntity<>(maintanenceRequestDetail, HttpStatus.ACCEPTED);
        }

        @DeleteMapping("{id}")
        public ResponseEntity delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
            maintanenceRequestService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

