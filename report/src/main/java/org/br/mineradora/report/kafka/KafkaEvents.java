package org.br.mineradora.report.kafka;

import org.br.mineradora.report.dto.ProposalDTO;
import org.br.mineradora.report.dto.QuotationDTO;
import org.br.mineradora.report.service.OpportunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEvents {

    private final OpportunityService opportunityService;

    public KafkaEvents(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvents.class);

    @KafkaListener(topics = "proposal", groupId = "proposal")
    public void receiveProposal(ProposalDTO proposal) {
        LOG.info("-- Recebendo nova proposta do tópico Kafka --");
        opportunityService.buildOpportunity(proposal);
    }

    @KafkaListener(topics = "quotation", groupId = "quotation")
    public void receiveQuotation(QuotationDTO quotation) {
        LOG.info("-- Recebendo nova proposta do tópico Kafka --");
        opportunityService.saveQuotation(quotation);
    }
}
