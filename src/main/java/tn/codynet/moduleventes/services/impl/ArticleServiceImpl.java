package tn.codynet.moduleventes.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.codynet.moduleventes.dao.ArticleRepo;
import tn.codynet.moduleventes.entities.Article;
import tn.codynet.moduleventes.services.IArticleService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private ArticleRepo articleRepo;


    @Override
    public Article addArticle(Article article) {
        return articleRepo.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepo.findAll();
    }

    @Override
    public Optional<Article> findArticleById(long id) {
        return articleRepo.findById(id);
    }

    @Override
    public Article findByRefrence(String ref) {
        return articleRepo.findByReference(ref);
    }

    @Override
    public void deleteArticle(long id) {
        articleRepo.deleteById(id);
    }
}
