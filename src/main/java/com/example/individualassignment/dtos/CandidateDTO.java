package com.example.individualassignment.dtos;

import com.example.individualassignment.entities.Party;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidateDTO {
    private int id;
    private String name;
  //  private Party party;
}
