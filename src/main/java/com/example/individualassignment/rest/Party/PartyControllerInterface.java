package com.example.individualassignment.rest.Party;

import com.example.individualassignment.dtos.PartyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PartyControllerInterface {

    @GetMapping
    List<PartyDTO> getAll();

    @GetMapping("/{id}")
    PartyDTO getById(@PathVariable int id);

    @PostMapping("/parties")
    @ResponseStatus(HttpStatus.CREATED)
    PartyDTO create(@RequestBody PartyDTO partyDTO);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") int id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    PartyDTO update(@PathVariable("id") int id, @RequestBody PartyDTO partyDTO);

}