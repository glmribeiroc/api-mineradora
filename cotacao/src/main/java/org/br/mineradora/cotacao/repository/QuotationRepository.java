package org.br.mineradora.cotacao.repository;

import org.br.mineradora.cotacao.entity.QuotationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<QuotationEntity, Long> {
}
