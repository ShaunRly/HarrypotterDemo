package com.Ironhack.RelationshipDemo.dao;

import com.Ironhack.RelationshipDemo.enums.House;
import com.Ironhack.RelationshipDemo.enums.Wing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "house_assignment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HouseAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private House house;

    @Enumerated(EnumType.STRING)
    private Wing wing;

    private Integer assignedBed;

    @OneToOne(mappedBy = "houseAssignment")
    private Student student;

    public HouseAssignment(House house, Wing wing, Integer assignedBed) {
        this.house = house;
        this.wing = wing;
        this.assignedBed = assignedBed;
    }
}
