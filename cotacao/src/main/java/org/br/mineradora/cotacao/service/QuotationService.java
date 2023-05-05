package org.br.mineradora.cotacao.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import org.br.mineradora.cotacao.client.CurrencyPriceClient;
import org.br.mineradora.cotacao.dto.CurrencyPriceDTO;
import org.br.mineradora.cotacao.dto.QuotationDTO;
import org.br.mineradora.cotacao.entity.QuotationEntity;
import org.br.mineradora.cotacao.message.KafkaEvents;
import org.br.mineradora.cotacao.repository.QuotationRepository;
import org.springframework.stereotype.Service;

@Service
public class QuotationService {

    private CurrencyPriceClient currencyPriceClient;

    private QuotationRepository quotationRepository;

    private KafkaEvents kafkaEvents;

    public QuotationService(CurrencyPriceClient currencyPriceClient, QuotationRepository quotationRepository,
            KafkaEvents kafkaEvents) {
        this.currencyPriceClient = currencyPriceClient;
        this.quotationRepository = quotationRepository;
        this.kafkaEvents = kafkaEvents;
    }

    public void getCurrencyPrice() {
        CurrencyPriceDTO currencyPriceDTO = currencyPriceClient.getPriceByPair("USD-BRL");

        if (updateCurrentInfoPrice(currencyPriceDTO)) {
            kafkaEvents.sendNewKafkaEvent(QuotationDTO
                    .builder()
                    .currencyPrice(new BigDecimal(currencyPriceDTO.getUSDBRL().getBid()))
                    .date(new Date())
                    .build());
        }
    }

    private boolean updateCurrentInfoPrice(CurrencyPriceDTO currencyPriceInfo) {
        BigDecimal currentPrice = new BigDecimal(currencyPriceInfo.getUSDBRL().getBid());
        boolean updatePrice = false;

        List<QuotationEntity> quotationList = quotationRepository.findAll();

        if (quotationList.isEmpty()) {
            saveQuotation(currencyPriceInfo);
            updatePrice = true;
        } else {
            QuotationEntity lastDollarPrice = quotationList.get(quotationList.size() - 1);

            if (currentPrice.setScale(2, RoundingMode.HALF_DOWN).floatValue() > lastDollarPrice.getCurrencyPrice()
                    .floatValue()) {
                updatePrice = true;
                saveQuotation(currencyPriceInfo);
            }
        }

        return updatePrice;
    }

    private void saveQuotation(CurrencyPriceDTO currencyPriceDTO) {

        QuotationEntity quotation = new QuotationEntity();

        quotation.setData(new Date());
        quotation.setCurrencyPrice(new BigDecimal(currencyPriceDTO.getUSDBRL().getBid()));
        quotation.setPctChange(currencyPriceDTO.getUSDBRL().getPctChange());
        quotation.setPair("USD-BRL");

        quotationRepository.save(quotation);
    }

}
