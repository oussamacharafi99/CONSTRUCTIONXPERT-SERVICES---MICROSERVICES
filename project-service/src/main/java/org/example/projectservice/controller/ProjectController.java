package org.example.projectservice.controller;

import org.example.projectservice.model.Project;
import org.example.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("save")
    public String save(@RequestBody Project project) {
        projectService.save(project);
        return "The Project Saved Successfully";
    }

    @PutMapping("update/{id}")
    public String update(@RequestBody Project project, @PathVariable Integer id) {
        projectService.updateProjectById(id, project);
        return "The Project Updated Successfully";
    }

    @GetMapping("get+all")
    public List<Project> getAll() {
        return projectService.getAllProjects();
    }

    @GetMapping("get+id/{id}")
    public Project getById(@PathVariable Integer id) {
        return projectService.getProjectById(id);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Integer id ) {
        projectService.deleteProjectById(id);
        return "The Project Deleted Successfully";
    }
}
