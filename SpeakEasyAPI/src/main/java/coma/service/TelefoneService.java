package coma.service;

import coma.models.Telefone;
import coma.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Serviço responsável por lógica de negócios relacionada aos telefones.
 */
@Service
public class TelefoneService {
    @Autowired
    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    private final TelefoneRepository telefoneRepository;
    /**
     * Obtém um telefone pelo seu ID.
     *
     * @param id ID do telefone a ser obtido
     * @return O telefone com o ID especificado
     * @throws Exception Se o telefone não for encontrado
     */
    @Cacheable(value = "telefoneCache", key = "id")
    @Transactional(readOnly = true)
    public Telefone obterTelefone(Long id) throws Exception {
        Optional<Telefone> telefoneOptional = telefoneRepository.findById(id);
        if (telefoneOptional.isPresent()) {
            return telefoneOptional.get();
        } else {
            throw new Exception("Telefone não encontrado com o número: " + id);
        }
    }



    @Async
    @Transactional
    public boolean numeroTele(int nrTelefone) {
        Telefone telefone = telefoneRepository.findByNrTelefone(nrTelefone) ;
        if (telefone == null) {
            return false;
        }
        else if (telefone.getNrTelefone() == nrTelefone){
            return true;
        }
        else{
            return false;
        }
    }
}
