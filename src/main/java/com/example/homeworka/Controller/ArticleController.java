package com.example.homeworka.Controller;


import com.example.homeworka.Serveic.ArticleServeic;
import com.example.homeworka.model.Article;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleServeic articleServeic;

    @GetMapping("/get")
    public ResponseEntity getArticle() {
        return ResponseEntity.status(200).body(articleServeic.getArticles());
    }

    @PostMapping("/add")
    public ResponseEntity addArticle(@Valid @RequestBody Article article, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        } else {
            articleServeic.addArticles(article);
            return ResponseEntity.status(200).body("added article");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateArticle(@Valid @RequestBody Article article, Errors errors,@PathVariable int id) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            if (articleServeic.updateArticle(article,id)){
                return ResponseEntity.status(200).body("updated article");
            }
            return ResponseEntity.status(400).body("update failed check the id");

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteArticle(@PathVariable int id) {
        if (articleServeic.deleteArticle(id)){
            return ResponseEntity.status(200).body("deleted article");
        }
        return ResponseEntity.status(400).body("delete failed check the id");
    }

    @PutMapping("/change/publish/{id}")
    public ResponseEntity changePublishArticle(@PathVariable int id) {
        if (articleServeic.publishArticle(id)){
            return ResponseEntity.status(200).body("published article");
        }else {
            return ResponseEntity.status(400).body("publish failed check the id");
        }
    }
    @GetMapping("/get/publish")
    public ResponseEntity getPublishArticle() {
        if (articleServeic.PublishedNewsArticles()==null){
            return ResponseEntity.status(400).body("No articles found");
        }else {
            return ResponseEntity.status(200).body(articleServeic.PublishedNewsArticles());
        }
    }

    @GetMapping("/get/by/{category}")
    public ResponseEntity getArticleByCategory(@PathVariable String category) {
        if (articleServeic.articlesByCategory(category)==null){
            return ResponseEntity.status(400).body("check your category");
        }else {
            return ResponseEntity.status(200).body(articleServeic.articlesByCategory(category));
        }
    }

}
