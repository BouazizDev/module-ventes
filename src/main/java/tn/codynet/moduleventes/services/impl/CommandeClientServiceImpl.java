package tn.codynet.moduleventes.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.codynet.moduleventes.dao.ArticleRepo;
import tn.codynet.moduleventes.dao.ClientRepo;
import tn.codynet.moduleventes.dao.CommandeClientRepo;
import tn.codynet.moduleventes.dao.LigneCommandeClientRepo;
import tn.codynet.moduleventes.entities.CommandeClient;
import tn.codynet.moduleventes.entities.LigneCommandeClient;
import tn.codynet.moduleventes.services.ICommandeClientService;
import tn.codynet.moduleventes.entities.EtatCommande;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CommandeClientServiceImpl  implements ICommandeClientService {
    private ArticleRepo articleRepo;
    private ClientRepo clientRepo;
    private CommandeClientRepo commandeClientRepo;
    private LigneCommandeClientRepo ligneCommandeClientRepo;
    @Autowired
    public CommandeClientServiceImpl(ArticleRepo articleRepo, ClientRepo clientRepo, CommandeClientRepo commandeClientRepo,LigneCommandeClientRepo ligneCommandeClientRepo) {
        this.articleRepo = articleRepo;
        this.clientRepo = clientRepo;
        this.commandeClientRepo = commandeClientRepo;
        this.ligneCommandeClientRepo = ligneCommandeClientRepo;
    }

    @Override
    public CommandeClient addCommandeClient(CommandeClient commandeClient) {
        if(clientRepo.findById(commandeClient.getClient().getId()).isEmpty()){
            log.warn("Client avec l'id {} n'existe pas",commandeClient.getClient().getId());
        }
        if(commandeClient.getLigneCommandeClients()!=null){
            commandeClient.getLigneCommandeClients().forEach(ligCmdClt->{
                if(articleRepo.findById(ligCmdClt.getArticle().getId()).isEmpty()){
                    log.warn("impossible de trouver l'article avec l'id : "+ ligCmdClt.getArticle().getId());


                }
            });
        }
        if(!Objects.isNull(commandeClient.getId())&& commandeClient.isCommandeLivree() ){
            log.warn("on ne peut pas modifier une commande livree");
        }
        CommandeClient savedCommande = commandeClientRepo.save(commandeClient);
        commandeClient.getLigneCommandeClients().forEach(ligCmdclt ->{
            ligCmdclt.setCommandeClient(savedCommande);
            ligneCommandeClientRepo.save(ligCmdclt);
        });
        return savedCommande;
    }

    @Override
    public List<CommandeClient> findAll() {
        return commandeClientRepo.findAll();
    }

    @Override
    public Optional<CommandeClient> findCommandeClientById(long id) {
        return commandeClientRepo.findById(id);
    }

    @Override
    public Optional<CommandeClient> findByReference(String ref) {
        return commandeClientRepo.findByReference(ref);
    }

    @Override
    public void deleteCommandeClient(long id) {
        commandeClientRepo.deleteById(id);
    }

    @Override
    public CommandeClient updateEtat(long id, EtatCommande etatCommande) {
        CommandeClient commandeClient = findCommandeClientById(id).get();
        if(commandeClient!=null&& commandeClient.isCommandeLivree()==false){
            commandeClient.setEtatCommande(etatCommande);
            commandeClientRepo.save(commandeClient);
        }else {
            log.warn("On ne peut pas modifier l'etat de la commande");
        }
        return commandeClient;
    }


}
