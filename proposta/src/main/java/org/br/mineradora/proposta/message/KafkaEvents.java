package org.br.mineradora.proposta.message;

import org.br.mineradora.proposta.dto.ProposalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEvents {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvents.class);

    private KafkaTemplate<String, ProposalDTO> kafkaTemplate;

    public KafkaEvents(KafkaTemplate<String, ProposalDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNewKafkaEvent(ProposalDTO proposalDTO) {
        LOG.info("-- Enviando Proposta para Topico Kafka --");
        kafkaTemplate.send("proposal", proposalDTO);
    }

}
