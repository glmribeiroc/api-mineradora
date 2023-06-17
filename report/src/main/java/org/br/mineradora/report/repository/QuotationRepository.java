package org.br.mineradora.report.repository;

import java.util.Optional;

import org.br.mineradora.report.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {

    Optional<Quotation> findTopByOrderByIdDesc();

}
