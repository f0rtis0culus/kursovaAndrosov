package com.example.demo.controllers;

import com.example.demo.entities.Workspace;
import com.example.demo.repositories.WorkspaceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workspaces")
public class WorkspaceController {

  private final WorkspaceRepository workspaceRepository;

  public WorkspaceController(WorkspaceRepository workspaceRepository) {
    this.workspaceRepository = workspaceRepository;
  }

  @GetMapping
  public List<Workspace> getAllWorkspaces() {
    return workspaceRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Workspace> getWorkspaceById(@PathVariable Long id) {
    return workspaceRepository.findById(id);
  }

  @PostMapping
  public Workspace createWorkspace(@RequestBody Workspace workspace) {
    return workspaceRepository.save(workspace);
  }

  @PutMapping("/{id}")
  public Workspace updateWorkspace(@PathVariable Long id, @RequestBody Workspace updatedWorkspace) {
    Workspace workspace = workspaceRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Workspace not found"));

    workspace.setName(updatedWorkspace.getName());
    workspace.setLocation(updatedWorkspace.getLocation());
    workspace.setCapacity(updatedWorkspace.getCapacity());

    return workspaceRepository.save(workspace);
  }

  @DeleteMapping("/{id}")
  public void deleteWorkspace(@PathVariable Long id) {
    workspaceRepository.deleteById(id);
  }
}
