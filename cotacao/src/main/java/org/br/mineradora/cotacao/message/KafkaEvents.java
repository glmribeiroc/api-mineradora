package org.br.mineradora.cotacao.message;

import org.br.mineradora.cotacao.dto.QuotationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEvents {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvents.class);

    private KafkaTemplate<String, QuotationDTO> kafkaTemplate;

    public KafkaEvents(KafkaTemplate<String, QuotationDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNewKafkaEvent(QuotationDTO quotationDTO) {
        LOG.info("-- Enviando Cotacao para Topico Kafka --");
        kafkaTemplate.send("quotation", quotationDTO);
    }

}
