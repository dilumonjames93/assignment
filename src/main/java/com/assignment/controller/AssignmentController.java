package com.assignment.controller;

import com.assignment.model.AssignmentModel;
import com.assignment.model.request.AssignmentRequest;
import com.assignment.service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping("/assignment")
    public ResponseEntity getAssignments(@RequestParam(required = false) String id) {
        if (id == null) {
            return ResponseEntity.ok(assignmentService.readAllAssignment());
        }
        return ResponseEntity.ok(assignmentService.readAssignmentById(id));
    }

    @GetMapping("/assignment/{id}")
    public ResponseEntity<AssignmentModel> getAssignment(@PathVariable String id) {
        return ResponseEntity.ok(assignmentService.readAssignmentById(id));
    }

    @PostMapping("/assignment")
    public ResponseEntity<AssignmentModel> createAssignment(@RequestBody AssignmentRequest request) {
        return ResponseEntity.ok(assignmentService.createAssignment(request));
    }

    @DeleteMapping("/assignment/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable String id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/assignment/{id}")
    public ResponseEntity<AssignmentModel> updateAssignment(@RequestBody AssignmentRequest request, @PathVariable String id) {
        assignmentService.updateAssignment(id, request);
        return ResponseEntity.ok().build();
    }

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }
}
