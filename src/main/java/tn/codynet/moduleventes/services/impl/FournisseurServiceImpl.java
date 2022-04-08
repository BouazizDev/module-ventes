package tn.codynet.moduleventes.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.codynet.moduleventes.dao.FournisseurRepo;
import tn.codynet.moduleventes.entities.Fournisseur;
import tn.codynet.moduleventes.services.IFournisseurService;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class FournisseurServiceImpl implements IFournisseurService {
    @Autowired
    private FournisseurRepo fournisseurRepo;
    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepo.save(fournisseur);
    }

    @Override
    public List<Fournisseur> findAll() {
        return fournisseurRepo.findAll();
    }

    @Override
    public Optional<Fournisseur> findFournisseurById(long id) {
        return fournisseurRepo.findById(id);
    }

    @Override
    public Fournisseur findByRefrence(String ref) {
        return fournisseurRepo.findByReference(ref);
    }

    @Override
    public void deleteFournisseur(long id) { fournisseurRepo.deleteById(id);    }
}
