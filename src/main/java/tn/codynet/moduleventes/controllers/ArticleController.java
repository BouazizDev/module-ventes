package tn.codynet.moduleventes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.codynet.moduleventes.services.entities.Article;
import tn.codynet.moduleventes.services.impl.ArticleServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {
    @Autowired
    ArticleServiceImpl articleService;
    @PostMapping(path = "article/add")
    Article addArticle(@RequestBody Article article){
        return articleService.addArticle(article);
    };
    @GetMapping(path = "/articles")
    List<Article> findAll(){
        return articleService.findAll();
    };
    @GetMapping(path = "/article/{id}")
    Optional<Article> findArticleById(@PathVariable long id){
        return articleService.findArticleById(id);
    };
    @GetMapping(path = "/article/{ref}")
    Article findByRefrence(@PathVariable String ref){
        return  articleService.findByRefrence(ref);
    };
    @DeleteMapping(path = "/article/{id}")
    void deleteArticle(long id){
        articleService.deleteArticle(id);
    };
}
