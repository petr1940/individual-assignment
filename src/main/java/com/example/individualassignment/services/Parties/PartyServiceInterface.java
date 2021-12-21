package com.example.individualassignment.services.Parties;

import com.example.individualassignment.entities.Candidate;
import com.example.individualassignment.entities.Party;

import java.util.List;

public interface PartyServiceInterface {
    List<Party> getAllParties();
    Party getById(int id);
    Party create(Party party);
    Party updateParty(int partyId, Party party);
    void deleteParty(int id);
}
