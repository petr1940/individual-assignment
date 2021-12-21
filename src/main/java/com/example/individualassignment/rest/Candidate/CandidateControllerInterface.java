package com.example.individualassignment.rest.Candidate;

import com.example.individualassignment.dtos.CandidateDTO;
import com.example.individualassignment.entities.Party;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CandidateControllerInterface {

    @GetMapping
    List<CandidateDTO> getAll();

    @GetMapping("/{id}")
    CandidateDTO getById(@PathVariable int id);

    @PostMapping("/candidates")
    @ResponseStatus(HttpStatus.CREATED)
    CandidateDTO create(@RequestBody CandidateDTO candidateDTO, @PathVariable int partyID);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") int id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    CandidateDTO update(@PathVariable("id") int id, @RequestBody CandidateDTO candidateDTO);

}
