package tn.codynet.moduleventes.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.codynet.moduleventes.dao.CommandeClientRepo;
import tn.codynet.moduleventes.dao.FactureClientRepo;
import tn.codynet.moduleventes.dao.LigneFactureClientRepo;
import tn.codynet.moduleventes.entities.*;
import tn.codynet.moduleventes.services.IFactureClientService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class FactureClientServiceImpl implements IFactureClientService {

    private CommandeClientRepo commandeClientRepo;
    private FactureClientRepo factureClientRepo;
    private LigneFactureClientRepo ligneFactureClientRepo;
    @Autowired
    public FactureClientServiceImpl(CommandeClientRepo commandeClientRepo, FactureClientRepo factureClientRepo, LigneFactureClientRepo ligneFactureClientRepo) {
        this.commandeClientRepo = commandeClientRepo;
        this.factureClientRepo = factureClientRepo;
        this.ligneFactureClientRepo = ligneFactureClientRepo;
    }

    @Override
    public FactureClient addFactureClient(FactureClient factureClient) {
        factureClient.getLigneFactureClient().forEach(ligFacClt->{
            if (commandeClientRepo.findById(ligFacClt.getCommandeClient().getId()).isEmpty()
                    &&!ligFacClt.getCommandeClient().getEtatCommande().equals(EtatCommande.VALIDE)){
               log.warn("on peut pas cree une facture pour une commande non validé");
            }
        });
        if(!Objects.isNull(factureClient.getId())&& factureClient.isFactureValide() ){
            log.warn("on ne peut pas modifier une facture valide");

        }
        FactureClient savedFacture = factureClientRepo.save(factureClient);
        factureClient.getLigneFactureClient().forEach(ligCmdclt ->{
            ligCmdclt.setFactureClient(savedFacture);
            ligneFactureClientRepo.save(ligCmdclt);
        });
        return savedFacture;
    }

    @Override
    public List<FactureClient> findAll() {
        return factureClientRepo.findAll();
    }

    @Override
    public Optional<FactureClient> findFactureClientById(long id) {
        return factureClientRepo.findById(id);
    }

    @Override
    public Optional<FactureClient> findByReference(String ref) {
        return factureClientRepo.findByRefrence(ref);
    }

    @Override
    public void deleteFactureClient(long id) {
        factureClientRepo.deleteById(id);
    }

    @Override
    public FactureClient updateEtat(long id, EtatFacture etatFacture) {
        FactureClient factureClient = factureClientRepo.findById(id).get();
        if(!factureClient.isFactureValide()&&factureClient!=null){
            factureClient.setEtatFacture(etatFacture);
            factureClientRepo.save(factureClient);
        }
        return factureClient;
    }
}
