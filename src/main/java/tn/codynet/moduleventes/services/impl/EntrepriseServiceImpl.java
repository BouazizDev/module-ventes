package tn.codynet.moduleventes.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.codynet.moduleventes.dao.EntrepriseRepo;
import tn.codynet.moduleventes.services.IEntrepriseService;
import tn.codynet.moduleventes.services.entities.Entreprise;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EntrepriseServiceImpl implements IEntrepriseService {
    @Autowired
    private EntrepriseRepo entrepriseRepo;
    @Override
    public Entreprise addEntreprise(Entreprise entreprise) {
        return entrepriseRepo.save(entreprise);
    }


    @Override
    public Optional<Entreprise> findEntrepriseById(long id) {
        return entrepriseRepo.findById(id);
    }


    @Override
    public void deleteEntreprise(long id) {
        entrepriseRepo.deleteById(id);
    }
}
