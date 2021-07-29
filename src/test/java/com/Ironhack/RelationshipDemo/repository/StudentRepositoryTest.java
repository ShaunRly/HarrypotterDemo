package com.Ironhack.RelationshipDemo.repository;

import com.Ironhack.RelationshipDemo.dao.HouseAssignment;
import com.Ironhack.RelationshipDemo.dao.Student;
import com.Ironhack.RelationshipDemo.enums.House;
import com.Ironhack.RelationshipDemo.enums.Wing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    HouseAssignmentRepository houseAssignmentRepository;

    private Student studentHarry;
    private Student studentDraco;

    @BeforeEach
    void setUp() {
        HouseAssignment harryHouse = houseAssignmentRepository.save(new HouseAssignment(House.GRYFFINDOR, Wing.EAST, 123));
        HouseAssignment dracoHouse = houseAssignmentRepository.save(new HouseAssignment(House.SLYTHERIN, Wing.NORTH, 999));
        studentHarry = new Student("Harry", "Potter", harryHouse);
        studentRepository.save(studentHarry);
        studentDraco = new Student("Draco", "Malfoy", dracoHouse);
        studentRepository.save(studentDraco);

    }

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void findByID_validID_student(){
        Optional<Student> studentOptional = studentRepository.findById(studentHarry.getId());
        assertTrue(studentOptional.isPresent());
        assertEquals(House.GRYFFINDOR, studentOptional.get().getHouseAssignment().getHouse());
    }

}