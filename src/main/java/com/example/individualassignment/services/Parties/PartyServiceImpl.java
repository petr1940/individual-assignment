package com.example.individualassignment.services.Parties;

import com.example.individualassignment.entities.Candidate;
import com.example.individualassignment.entities.Party;
import com.example.individualassignment.exceptionHandling.ResourceNotFoundException;
import com.example.individualassignment.repositories.CandidateRepository;
import com.example.individualassignment.repositories.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartyServiceImpl implements PartyServiceInterface{
    private final CandidateRepository candidateRepository;
    private final PartyRepository partyRepository;

    public PartyServiceImpl(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }

    private String errorMessage(long id){
        return "Not found candidate with id = " + id;
    }


    @Override
    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    @Override
    public Party getById(int id) {
        return partyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(errorMessage(id)));

    }

    @Override
    public Party create(Party party) {
        if (partyRepository.existsByName(party.getName())) {
            throw new IllegalArgumentException("A category with name: " + party.getName() + " already exists");
        }
        return partyRepository.save(party);
    }

    @Override
    public Party updateParty(int partyId, Party party) {
        Party updatedParty = partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage(partyId)));
        if (party.getName() != null) {
            updatedParty.setName(party.getName());
        }
        else{
            throw new IllegalArgumentException("The name of the party is required!");
        }

        return partyRepository.save(updatedParty);
    }

    @Override
    public void deleteParty(int id) {
        if (!partyRepository.existsById(id)) throw new ResourceNotFoundException("This party doesn't exist");
        partyRepository.deleteById(id);
    }
}
