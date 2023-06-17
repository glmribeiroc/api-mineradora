package org.br.mineradora.report.service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import org.br.mineradora.report.dto.OpportunityDTO;
import org.br.mineradora.report.dto.ProposalDTO;
import org.br.mineradora.report.dto.QuotationDTO;
import org.br.mineradora.report.entity.Opportunity;
import org.br.mineradora.report.entity.Quotation;
import org.br.mineradora.report.repository.OpportunityRepository;
import org.br.mineradora.report.repository.QuotationRepository;
import org.springframework.stereotype.Service;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    private final QuotationRepository quotationRepository;

    private final OpportunityRepository opportunityRepository;

    public OpportunityServiceImpl(QuotationRepository quotationRepository,
            OpportunityRepository opportunityRepository) {
        this.quotationRepository = quotationRepository;
        this.opportunityRepository = opportunityRepository;
    }

    @Override
    public void buildOpportunity(ProposalDTO proposalDTO) {
        Quotation lastQuotation = quotationRepository.findTopByOrderByIdDesc().get();

        Opportunity opportunity = new Opportunity();
        opportunity.setDate(new Date());
        opportunity.setProposalId(proposalDTO.getProposalId());
        opportunity.setCustomer(proposalDTO.getCustomer());
        opportunity.setPriceTonne(proposalDTO.getPriceTonne());
        opportunity.setLastDollarQuotation(lastQuotation.getCurrencyPrice());

        opportunityRepository.save(opportunity);
    }

    @Override
    public List<OpportunityDTO> generateOpportunityDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveQuotation(QuotationDTO quotationDTO) {
        // TODO Auto-generated method stub

    }

    @Override
    public ByteArrayInputStream generateCSVOpportunityReport() {
        // TODO Auto-generated method stub
        return null;
    }

}
