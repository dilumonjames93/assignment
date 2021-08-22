package com.assignment.service;

import com.assignment.exception.AssignmentException;
import com.assignment.exception.GlobalErrorCode;
import com.assignment.model.AssignmentModel;
import com.assignment.model.request.AssignmentRequest;
import com.assignment.repository.AssignmentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AssignmentService {
    private final AssignmentRepo assignmentRepo;

    public List<AssignmentModel> readAllAssignment() {
        return assignmentRepo.findAll();
    }

    public AssignmentModel readAssignmentById(String id) throws AssignmentException {
        Optional<AssignmentModel> assignmentModel = assignmentRepo.findById(id);
        Integer aa[]={1,2};
        System.out.println(aa[2]);
        if (assignmentModel.isPresent()) {
            return assignmentModel.get();
        }
        throw new AssignmentException("Assignment Not Found");
    }

    public AssignmentModel createAssignment(AssignmentRequest assignmentRequest) throws AssignmentException {
        validateEmail(assignmentRequest.getEmail());
        AssignmentModel assignmentModel = new AssignmentModel();
        BeanUtils.copyProperties(assignmentRequest, assignmentModel);
        return assignmentRepo.save(assignmentModel);
    }

    public void deleteAssignment(String id) {
        assignmentRepo.deleteById(id);
    }

    public AssignmentModel updateAssignment(String id, AssignmentRequest request) throws AssignmentException {
        validateEmail(request.getEmail());
        Optional<AssignmentModel> assignmentModel = assignmentRepo.findById(id);
        if (!assignmentModel.isPresent()) {
            throw new AssignmentException("Assignment not present in the database");
        }
        AssignmentModel temp = assignmentModel.get();
        if (request.getAge() != null) {
            temp.setAge(request.getAge());
        }
        if (request.getDob() != null) {
            temp.setDob(request.getDob());
        }
        if (request.getEmail() != null) {
            temp.setEmail(request.getEmail());
        }
        if (request.getName() != null) {
            temp.setName(request.getName());
        }
        return assignmentRepo.save(temp);
    }

    public AssignmentService(AssignmentRepo assignmentRepo) {
        this.assignmentRepo = assignmentRepo;
    }

    private void validateEmail(String email) throws AssignmentException {
        if (email != null && !email.isEmpty()) {
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                throw new AssignmentException("Email Id not valid");
            }
        }
    }
}
