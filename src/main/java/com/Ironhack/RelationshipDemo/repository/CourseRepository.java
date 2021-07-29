package com.Ironhack.RelationshipDemo.repository;

import com.Ironhack.RelationshipDemo.dao.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
}
