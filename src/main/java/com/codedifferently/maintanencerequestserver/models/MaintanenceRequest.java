package com.codedifferently.maintanencerequestserver.models;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

    @Entity // JPA to save to the database
    @NoArgsConstructor // Non argument constructor
    @RequiredArgsConstructor // parameterized constructor
    @Data // getters and setters
    public class MaintanenceRequest {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NonNull
        private String firstName;

        @NonNull
        private String lastName;

        @NonNull
        private String email;

        @NonNull
        private String aptNumber;

        @NonNull
        private String description;

        @NonNull
        private Date createdAt;

        public String toString(){
            return String.format("%d %s %s %s %s %s", id, firstName,lastName,email,aptNumber,description);
        }

        public void getClass(String firstName) {
        }
    }

}
