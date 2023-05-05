package org.br.mineradora.cotacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyPriceDTO {

    @JsonProperty("USDBRL")
    private USDBRL USDBRL;

}
