package tn.codynet.moduleventes.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.codynet.moduleventes.dao.TaxeRepo;
import tn.codynet.moduleventes.services.entities.Taxe;
import tn.codynet.moduleventes.services.ITaxeService;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class TaxeServiceImpl implements ITaxeService {
    @Autowired
    private TaxeRepo taxeRepo;
    @Override
    public Taxe addTaxe(Taxe taxe) {
        return taxeRepo.save(taxe);
    }

    @Override
    public List<Taxe> findAll() {
        return taxeRepo.findAll();
    }

    @Override
    public Optional<Taxe> findTaxeById(long id) {
        return taxeRepo.findById(id);
    }

    @Override
    public void deleteTaxe(long id) {
        taxeRepo.deleteById(id);
    }
}
