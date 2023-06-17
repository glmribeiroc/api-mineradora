package org.br.mineradora.report.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "quotation")
public class Quotation {

    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    @Column(name = "currency_price")
    private BigDecimal currencyPrice;
}
