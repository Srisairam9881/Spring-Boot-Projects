package com.example.StudentMangementSystem.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentMangementSystem.entity.studentData;
@Repository
public interface studentReposirty extends JpaRepository<studentData, Long> {

}
