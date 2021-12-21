package com.example.individualassignment.rest.Candidate;

import com.example.individualassignment.dtos.CandidateDTO;
import com.example.individualassignment.dtos.converter.DTOConverter;
import com.example.individualassignment.entities.Party;
import com.example.individualassignment.services.Candidates.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/candidate")
public class CandidateControllerImpl implements CandidateControllerInterface {
    @Autowired
    CandidateServiceImpl candidateService;
    DTOConverter dtoConverter;

    @Autowired
    public CandidateControllerImpl(CandidateServiceImpl candidateService, DTOConverter dtoConverter) {
        this.candidateService = candidateService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public List<CandidateDTO> getAll() {
        return candidateService.getAllCandidates().stream()
                .map(candidate -> dtoConverter.convertToCandidateDTO(candidate)).collect(Collectors.toList());
    }

    @Override
    public CandidateDTO getById(int id) {
        return dtoConverter.convertToCandidateDTO(candidateService.getById(id));
    }

    @Override
    public CandidateDTO create(CandidateDTO candidateDTO, int partyID) {
        return dtoConverter.convertToCandidateDTO(candidateService.create(dtoConverter.convertToCandidate(candidateDTO), partyID));
    }

    @Override
    public void deleteById(int id) {
        candidateService.deleteCandidate(id);
    }

    @Override
    public CandidateDTO update(int id, CandidateDTO candidateDTO) {
        return dtoConverter.convertToCandidateDTO(candidateService.updateCandidate(id, dtoConverter.convertToCandidate(candidateDTO)));

    }
}
