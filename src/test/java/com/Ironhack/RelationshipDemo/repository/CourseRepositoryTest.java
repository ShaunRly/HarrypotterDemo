package com.Ironhack.RelationshipDemo.repository;

import com.Ironhack.RelationshipDemo.dao.Course;
import com.Ironhack.RelationshipDemo.dao.Section;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    SectionRepository sectionRepository;

    private List<Course> courses;
    private List<Section> sections;
    @BeforeEach
    void setUp() {
        courses = courseRepository.saveAll(List.of(
                new Course("CS101", "Pociones"),
                new Course("CS102", "Defensa contra las artes oscuras")
        ));

        sections = sectionRepository.saveAll(List.of(
                new Section("CS101-A", (short) 1001, "Severus Snape", courses.get(0)),
                new Section("CS102-A", (short) 1002, "Severus Snape", courses.get(1)),
                new Section("CS102-B", (short) 1002, "Remus Lupin", courses.get(1))
        ));

    }

    @AfterEach
    void tearDown() {
        sectionRepository.deleteAll();
        courseRepository.deleteAll();

    }

    @Test
    void findById_validID_section(){
        var course = courseRepository.findById("CS101");
        var section = sectionRepository.findById("CS101-A");
        assertTrue(course.isPresent());
        assertEquals("Pociones", course.get().getCourseName());
        assertTrue(section.isPresent());
        assertEquals("Severus Snape", section.get().getProfessor());
        var sections = courseRepository.findById("CS102").get().getSections();
        assertEquals(2, sections.size());
    }
}