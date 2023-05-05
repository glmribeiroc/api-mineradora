package org.br.mineradora.cotacao.scheduler;

import org.br.mineradora.cotacao.service.QuotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuotationScheduler {

    private final Logger LOG = LoggerFactory.getLogger(QuotationScheduler.class);

    QuotationService quotationService;

    public QuotationScheduler(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @Scheduled(fixedRate = 15000)
    public void schedule() {
        LOG.info("-- Executando scheduler --");
        quotationService.getCurrencyPrice();
    }

}
