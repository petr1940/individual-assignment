package com.example.individualassignment.dtos.converter;

import com.example.individualassignment.dtos.CandidateDTO;
import com.example.individualassignment.entities.Candidate;
import com.example.individualassignment.entities.Party;
import com.example.individualassignment.dtos.PartyDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DTOConverter {

    ModelMapper modelMapper;


    @Autowired
    public DTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PartyDTO convertToPartyDTO(Party party) {

            return modelMapper.map(party, PartyDTO.class);
        }

    public Party convertToParty(PartyDTO partyDTO) {
        return modelMapper.map(partyDTO, Party.class);
    }

    public CandidateDTO convertToCandidateDTO(Candidate candidate) {

        return modelMapper.map(candidate, CandidateDTO.class);
    }

    public Candidate convertToCandidate(CandidateDTO candidateDTO) {
        return modelMapper.map(candidateDTO, Candidate.class);
    }

}
