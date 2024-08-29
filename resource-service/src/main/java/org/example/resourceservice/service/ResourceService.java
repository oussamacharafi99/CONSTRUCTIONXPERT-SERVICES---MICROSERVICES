package org.example.resourceservice.service;

import org.example.resourceservice.classe.Task;
import org.example.resourceservice.model.Resource;
import org.example.resourceservice.openfeign.TaskRest;
import org.example.resourceservice.repository.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private TaskRest taskRest;

    public Resource save(Resource resource) {
        return resourceRepo.save(resource);
    }

    public Resource findById(Integer id) {
        Resource resource = resourceRepo.findById(id).orElseThrow();
        Task task = taskRest.getTaskById(resource.getTask_id());
        resource.setTask(task);
        return resource;
    }

    public List<Resource> findAll() {
        List<Resource> resources = resourceRepo.findAll();
        for (Resource resource : resources) {
            Task task = taskRest.getTaskById(resource.getTask_id());
            resource.setTask(task);
        }
        return resources;
    }

    public Resource update(Integer id , Resource resource) {
        Resource updateResource = resourceRepo.findById(id).orElseThrow();
        updateResource.setTask_id(resource.getTask_id());
        updateResource.setStartDate(resource.getStartDate());
        updateResource.setResourceName(resource.getResourceName());
        updateResource.setResourceType(resource.getResourceType());

        return resourceRepo.save(updateResource);
    }

    public void delete(Integer id) {
        resourceRepo.deleteById(id);
    }



}
