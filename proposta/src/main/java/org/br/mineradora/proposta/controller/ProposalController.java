package org.br.mineradora.proposta.controller;

import org.br.mineradora.proposta.dto.ProposalDetailsDTO;
import org.br.mineradora.proposta.service.ProposalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proposal")
public class ProposalController {

    private final Logger LOG = LoggerFactory.getLogger(ProposalController.class);

    private final ProposalService proposalService;

    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProposalDetailsDTO> findDetailsProposal(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(proposalService.findByIdDTO(id));
    }

    @PostMapping
    public ResponseEntity<Void> createProposal(@RequestBody ProposalDetailsDTO proposalDetailsDTO) {
        LOG.info("--- Recebendo Proposta de Compra ---");

        try {
            proposalService.createNewProposal(proposalDetailsDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProposal(@PathVariable("id") long id) {
        try {
            proposalService.removeProposal(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
