package com.ait.springbootdemo.respository;

import com.ait.springbootdemo.entity.Department;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("MC")
                        .departmentCode("DDT01")
                        .departmentAddress("Delhi")
                        .build();

         entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){

        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"MC");

    }
}