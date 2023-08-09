package com.ait.springbootdemo.controller;

import com.ait.springbootdemo.entity.Department;
import com.ait.springbootdemo.error.DepartmentNotFoundException;
import com.ait.springbootdemo.service.DepartmentService;
import com.ait.springbootdemo.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.aspectj.weaver.patterns.DeclareParentsMixin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment on DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList on DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id")  Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")  Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully for id: "+departmentId;
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
    return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department findByDeparmentName(@PathVariable("name")  String departmentName){
        return departmentService.findByDepartmentName(departmentName);
    }
}
