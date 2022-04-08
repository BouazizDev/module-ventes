package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.entities.Article;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    Article addArticle(Article article);
    List<Article> findAll();
    Optional<Article> findArticleById(long id);
    Article findByRefrence(String ref);
    void deleteArticle(long id);
}
