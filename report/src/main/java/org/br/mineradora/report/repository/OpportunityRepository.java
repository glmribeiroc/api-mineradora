package org.br.mineradora.report.repository;

import org.br.mineradora.report.entity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

}
