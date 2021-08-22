package com.assignment.repository;

import com.assignment.model.AssignmentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssignmentRepo extends MongoRepository<AssignmentModel, String> {
}
