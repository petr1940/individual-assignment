package com.example.individualassignment.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="party_id", nullable=false)
    private Party party;



    @Column(unique = true)
    private String name;


    public Candidate(String name, Party party) {
        this.name = name;
        this.party = party;
    }
}
