package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.services.entities.Article;
@Repository
public interface ArticleRepo extends JpaRepository<Article,Long> {
    Article findByReference(String ref);
}
