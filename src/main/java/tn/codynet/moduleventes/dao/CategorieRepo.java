package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.services.entities.Categorie;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie,Long> {
    Categorie findByNom(String name);
}
