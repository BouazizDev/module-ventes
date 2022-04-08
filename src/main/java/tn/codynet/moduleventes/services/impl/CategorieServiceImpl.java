package tn.codynet.moduleventes.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.codynet.moduleventes.dao.CategorieRepo;
import tn.codynet.moduleventes.entities.Categorie;
import tn.codynet.moduleventes.services.ICategorieService;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class CategorieServiceImpl implements ICategorieService {
    @Autowired
    private CategorieRepo categorieRepo;
    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepo.save(categorie);
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepo.findAll();
    }

    @Override
    public Optional<Categorie> findCategorieById(long id) {
        return categorieRepo.findById(id);
    }

    @Override
    public void deleteCategorie(long id) {
        categorieRepo.deleteById(id);
    }


}
