package com.example.individualassignment.configuration;

import com.example.individualassignment.entities.Candidate;
import com.example.individualassignment.entities.Party;
import com.example.individualassignment.repositories.CandidateRepository;
import com.example.individualassignment.repositories.PartyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Profile("!test")
public class DataSetup implements CommandLineRunner {
        PartyRepository partyRepository;
        CandidateRepository candidateRepository;

        public DataSetup (PartyRepository partyRepository, CandidateRepository candidateRepository)
        {
            this.partyRepository = partyRepository;
            this.candidateRepository = candidateRepository;

        }

    @Override
    public void run(String... args) throws Exception {

        Party party1 = partyRepository.save(new Party("A", "Socialdemokratiet"));
        Party party2 = partyRepository.save(new Party("C", "Det konservative Folkeparti"));
        Party party3 = partyRepository.save(new Party("F", "SF, Socialistisk Folkeparti"));
        Party party4 = partyRepository.save(new Party("O", "Dansk Folkeparti"));
        Party party5 = partyRepository.save(new Party("V", "Venstre, Danmarks Liberale Parti"));
        Party party6 = partyRepository.save(new Party("Ø", "Enhedslisten + De Rød Grønne"));

        Candidate candidate1 = candidateRepository.save(new Candidate("Marcel Meijer", party1));
        Candidate candidate2 = candidateRepository.save(new Candidate("Michael Kristensen", party1));
        Candidate candidate3 = candidateRepository.save(new Candidate("Helle Hansen", party1));
        Candidate candidate4 = candidateRepository.save(new Candidate("Karina Knobelauch", party1));
        Candidate candidate5 = candidateRepository.save(new Candidate("Per Urban Olsen", party2));
        Candidate candidate6 = candidateRepository.save(new Candidate("Peter Askjær", party2));
        Candidate candidate7 = candidateRepository.save(new Candidate("Morten Ø. Kristensen", party2));
        Candidate candidate8 = candidateRepository.save(new Candidate("Katrine Høegh Mc Quaid", party6));
        Candidate candidate9 = candidateRepository.save(new Candidate("Pia Ramsing", party1));
        Candidate candidate10 = candidateRepository.save(new Candidate("Anders Baun Sørensen", party1));
        Candidate candidate11 = candidateRepository.save(new Candidate("Ulla Holm", party3));
        Candidate candidate12 = candidateRepository.save(new Candidate("Kjeld Bønkel", party3));
        Candidate candidate13 = candidateRepository.save(new Candidate("Per Mortensen", party4));


    }
}