package org.br.mineradora.cotacao.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class QuotationDTO {
    private Date date;
    private BigDecimal currencyPrice;
}
