package com.Ironhack.RelationshipDemo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "house_assignment_id")
    private HouseAssignment houseAssignment;

    public Student(String firstName, String lastName, HouseAssignment houseAssignment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.houseAssignment = houseAssignment;
    }
}
