package org.br.mineradora.proposta.controller;

import org.br.mineradora.proposta.dto.ProposalDetailsDTO;
import org.br.mineradora.proposta.service.ProposalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController(value = "/api/proposal")
public class ProposalController {

    private final Logger LOG = LoggerFactory.getLogger(ProposalController.class);

    private final ProposalService proposalService;

    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProposalDetailsDTO> findDetailsProposal(@PathParam("id") long id) {
        return ResponseEntity.ok().body(proposalService.findByIdDTO(id));
    }

}
