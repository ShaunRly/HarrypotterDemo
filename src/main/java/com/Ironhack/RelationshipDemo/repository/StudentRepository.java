package com.Ironhack.RelationshipDemo.repository;

import com.Ironhack.RelationshipDemo.dao.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
