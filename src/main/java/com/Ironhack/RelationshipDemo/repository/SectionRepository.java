package com.Ironhack.RelationshipDemo.repository;

import com.Ironhack.RelationshipDemo.dao.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {
}
