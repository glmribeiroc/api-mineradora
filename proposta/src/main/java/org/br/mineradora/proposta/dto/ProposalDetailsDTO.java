package org.br.mineradora.proposta.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.br.mineradora.proposta.entity.ProposalEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProposalDetailsDTO {
    private Long proposalId;
    private String customer;
    private BigDecimal priceTonne;
    private Integer tonnes;
    private String country;
    private Integer proposalValidityDays;

    public ProposalEntity toEntity(ProposalDetailsDTO proposalDetailsDTO) {
        ProposalEntity proposal = new ProposalEntity();

        proposal.setCreatedAt(new Date());
        proposal.setProposalValidityDays(proposalDetailsDTO.getProposalValidityDays());
        proposal.setCountry(proposalDetailsDTO.getCountry());
        proposal.setCustomer(proposalDetailsDTO.getCustomer());
        proposal.setPriceTonne(proposalDetailsDTO.getPriceTonne());
        proposal.setTonnes(proposalDetailsDTO.getTonnes());

        return proposal;
    }

    public ProposalDetailsDTO(ProposalEntity proposal) {
        this.proposalId = proposal.getId();
        this.customer = proposal.getCustomer();
        this.priceTonne = proposal.getPriceTonne();
        this.tonnes = proposal.getTonnes();
        this.country = proposal.getCountry();
        this.proposalValidityDays = proposal.getProposalValidityDays();
    }
}
