package com.ait.springbootdemo.service;

import com.ait.springbootdemo.entity.Department;
import com.ait.springbootdemo.respository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("PUNE")
                        .departmentCode("DDT01")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentName("IT"))
                .thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName= "IT";
        Department found =
                departmentService.findByDepartmentName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}