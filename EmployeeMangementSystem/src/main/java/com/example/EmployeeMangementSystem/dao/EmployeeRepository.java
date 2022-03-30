package com.example.EmployeeMangementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeMangementSystem.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
