package org.br.mineradora.cotacao.client;

import org.br.mineradora.cotacao.dto.CurrencyPriceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyPriceClient {

    private final Logger LOG = LoggerFactory.getLogger(CurrencyPriceClient.class);
    private final String apiPath = "https://economia.awesomeapi.com.br/last/";

    RestTemplate restTemplate = new RestTemplate();

    public CurrencyPriceDTO getPriceByPair(String pair) {
        LOG.info("-- Enviando httpclient -- ");
        CurrencyPriceDTO currencyPriceDTO = restTemplate.getForObject(apiPath + pair, CurrencyPriceDTO.class);
        return currencyPriceDTO;
    }

}
