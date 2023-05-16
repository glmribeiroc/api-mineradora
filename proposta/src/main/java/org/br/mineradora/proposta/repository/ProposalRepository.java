package org.br.mineradora.proposta.repository;

import org.br.mineradora.proposta.entity.ProposalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<ProposalEntity, Long> {
}
