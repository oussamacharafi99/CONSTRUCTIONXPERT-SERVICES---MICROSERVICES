package org.example.resourceservice.service;

import org.example.resourceservice.model.Resource;
import org.example.resourceservice.repository.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepo resourceRepo;

    public Resource save(Resource resource) {
        return resourceRepo.save(resource);
    }

    public Resource findById(Integer id) {
        return resourceRepo.findById(id).orElseThrow();
    }

    public List<Resource> findAll() {
        return resourceRepo.findAll();
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
