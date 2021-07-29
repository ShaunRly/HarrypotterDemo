package com.Ironhack.RelationshipDemo.repository;

import com.Ironhack.RelationshipDemo.dao.HouseAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseAssignmentRepository extends JpaRepository<HouseAssignment, Long> {
}
