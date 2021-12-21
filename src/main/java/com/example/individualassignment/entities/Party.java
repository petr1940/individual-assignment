package com.example.individualassignment.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @Column()
    private String abbreviation;

    @OneToMany(mappedBy="party")
    private Set<Candidate> candidate;




    public Party(String abbreviation, String name) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
}