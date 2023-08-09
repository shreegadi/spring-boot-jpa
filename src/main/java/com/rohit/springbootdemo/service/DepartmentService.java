package com.ait.springbootdemo.service;

import com.ait.springbootdemo.entity.Department;
import com.ait.springbootdemo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department findByDepartmentName(String departmentName);
}
