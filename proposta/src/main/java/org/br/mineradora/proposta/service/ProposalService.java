package org.br.mineradora.proposta.service;

import org.br.mineradora.proposta.dto.ProposalDetailsDTO;

public interface ProposalService {

    ProposalDetailsDTO findByIdDTO(long id);

}
