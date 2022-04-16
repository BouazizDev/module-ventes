package tn.codynet.moduleventes.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.codynet.moduleventes.dao.*;
import tn.codynet.moduleventes.entities.CommandeClient;
import tn.codynet.moduleventes.entities.EtatCommande;
import tn.codynet.moduleventes.services.ICommandeFournisseurService;
import tn.codynet.moduleventes.entities.CommandeFournisseur;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CommandeFournisseurImpl implements ICommandeFournisseurService {
    private ArticleRepo articleRepo;
    private FournisseurRepo fournisseurRepo;
    private CommandeFournisseurRepo commandeFournisseurRepo;
    private LigneCommandeFournisseurRepo ligneCommandeFournisseurRepo;

    @Autowired
    public CommandeFournisseurImpl(ArticleRepo articleRepo, FournisseurRepo fournisseurRepo, CommandeFournisseurRepo commandeFournisseurRepo, LigneCommandeFournisseurRepo ligneCommandeFournisseurRepo) {
        this.articleRepo = articleRepo;
        this.fournisseurRepo = fournisseurRepo;
        this.commandeFournisseurRepo = commandeFournisseurRepo;
        this.ligneCommandeFournisseurRepo = ligneCommandeFournisseurRepo;
    }


    @Override
    public CommandeFournisseur addCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
        if (fournisseurRepo.findById(commandeFournisseur.getFournisseur().getId()).isEmpty()) {
            log.warn("Fournisseur avec l'id {} n'existe pas", commandeFournisseur.getFournisseur().getId());
        }
        if (commandeFournisseur.getLigneCommandeFournisseurs() != null) {
            commandeFournisseur.getLigneCommandeFournisseurs().forEach(ligCmdClt -> {
                if (articleRepo.findById(ligCmdClt.getArticle().getId()).isEmpty()) {
                    log.warn("impossible d'engrigistrer l'article avec l'id : " + ligCmdClt.getArticle().getId());


                }
            });
        }
        CommandeFournisseur savedCommande = commandeFournisseurRepo.save(commandeFournisseur);
        commandeFournisseur.getLigneCommandeFournisseurs().forEach(ligCmdclt -> {
            ligCmdclt.setCommandeFournisseur(savedCommande);
            ligneCommandeFournisseurRepo.save(ligCmdclt);
        });
        return savedCommande;
    }

    @Override
    public List<CommandeFournisseur> findAll() {
        return commandeFournisseurRepo.findAll();
    }

    @Override
    public Optional<CommandeFournisseur> findCommandeFournisseurById(long id) {
        if (Objects.isNull(id)) {
            log.warn("L'id de la commande est null");
        }
        return commandeFournisseurRepo.findById(id);
    }
    @Override
    public CommandeFournisseur updateEtat(long id, EtatCommande etatCommande) {
        CommandeFournisseur commandeFournisseur = findCommandeFournisseurById(id).get();
        if(commandeFournisseur!=null&& commandeFournisseur.isCommandeLivree()==false){
            commandeFournisseur.setEtatCommande(etatCommande);
            commandeFournisseurRepo.save(commandeFournisseur);
        }else {
            log.warn("On ne peut pas modifier l'etat de la commande");
        }
        return commandeFournisseur;
    }
    @Override
    public Optional<CommandeFournisseur> findByReference(String ref) {
        if (ref.equals(null)) {
            log.warn("la refrence de l'article est null");
        }
        return commandeFournisseurRepo.findByReference(ref);
    }

    @Override
    public void deleteCommandeFournisseur(long id) {
        commandeFournisseurRepo.deleteById(id);

    }
}
