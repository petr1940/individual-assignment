package com.example.individualassignment.services.Candidates;
import com.example.individualassignment.entities.Candidate;
import com.example.individualassignment.entities.Party;
import com.example.individualassignment.exceptionHandling.ResourceNotFoundException;
import com.example.individualassignment.repositories.CandidateRepository;
import com.example.individualassignment.repositories.PartyRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateServiceInterface {

    private final CandidateRepository candidateRepository;
    private final PartyRepository partyRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }

    private String errorMessage(long id){
        return "Not found candidate with id = " + id;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate getById(int id) {
        return candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(errorMessage(id)));
    }

    @Override
    public Candidate create(Candidate candidate, int party_ID) {
        if (candidateRepository.existsByName(candidate.getName())) {
            throw new IllegalArgumentException("A category with name: " + candidate.getName() + " already exists");
        }
        return candidateRepository.save(new Candidate(candidate.getName(),
                partyRepository.findById(party_ID).orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("There is not such party in our system"))));
    }

    @Override
    public Candidate updateCandidate(int candidateId, Candidate candidate) {
        Candidate updatedCandidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage(candidateId)));
        if (candidate.getName() != null) {
            updatedCandidate.setName(candidate.getName());
        }
        else{
            throw new IllegalArgumentException("The name of the category is required!");
        }

        return candidateRepository.save(updatedCandidate);
    }

    @Override
    public void deleteCandidate(int id) {
        if (!candidateRepository.existsById(id)) throw new ResourceNotFoundException("This candidate doesn't exist");
        candidateRepository.deleteById(id);
    }
}