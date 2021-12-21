package com.example.individualassignment.services.Candidates;

import com.example.individualassignment.entities.Candidate;
import com.example.individualassignment.entities.Party;

import java.util.List;

public interface CandidateServiceInterface {
    List<Candidate> getAllCandidates();
    Candidate getById(int id);
    Candidate create(Candidate candidate, int party_ID);
    Candidate updateCandidate(int candidateId, Candidate candidate);
    void deleteCandidate(int id);
}
