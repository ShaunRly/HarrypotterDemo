package com.Ironhack.RelationshipDemo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Section {
    @Id
    private String id;
    private short roomNumber;
    private String professor;

    @ManyToOne
    @JoinColumn(name = "course_code")
    private Course course;
}
