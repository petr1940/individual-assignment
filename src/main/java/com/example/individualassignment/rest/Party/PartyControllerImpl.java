package com.example.individualassignment.rest.Party;

import com.example.individualassignment.dtos.PartyDTO;
import com.example.individualassignment.dtos.converter.DTOConverter;
import com.example.individualassignment.services.Parties.PartyServiceImpl;
import com.example.individualassignment.services.Parties.PartyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Part;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/party")
public class PartyControllerImpl  implements PartyControllerInterface{

    @Autowired
    PartyServiceImpl partyService;
    DTOConverter dtoConverter;

    @Autowired
    public PartyControllerImpl(PartyServiceImpl partyService, DTOConverter dtoConverter) {
        this.partyService = partyService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public List<PartyDTO> getAll() {
        return partyService.getAllParties().stream()
                .map(party -> dtoConverter.convertToPartyDTO(party)).collect(Collectors.toList());
    }

    @Override
    public PartyDTO getById(int id) {
        return dtoConverter.convertToPartyDTO(partyService.getById(id));
    }

    @Override
    public PartyDTO create(PartyDTO partyDTO) {
        return dtoConverter.convertToPartyDTO(partyService.create(dtoConverter.convertToParty(partyDTO)));
    }

    @Override
    public void deleteById(int id) {
        partyService.deleteParty(id);

    }

    @Override
    public PartyDTO update(int id, PartyDTO partyDTO) {
        return dtoConverter.convertToPartyDTO(partyService.updateParty(id, dtoConverter.convertToParty(partyDTO)));
    }
}
