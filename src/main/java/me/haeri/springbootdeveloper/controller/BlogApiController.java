package me.haeri.springbootdeveloper.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.haeri.springbootdeveloper.dto.AddArticleRequest;
import me.haeri.springbootdeveloper.dto.ArticleResponse;
import me.haeri.springbootdeveloper.dto.UpdateArticleRequest;
import me.haeri.springbootdeveloper.entity.Article;
import me.haeri.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

  private final BlogService blogService;

  // HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
  @PostMapping("/api/articles")
  public ResponseEntity<Article> addAriticle(@RequestBody AddArticleRequest request){
    Article savedArticle = blogService.save(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
  }

  @GetMapping("/api/articles")
  public ResponseEntity<List<ArticleResponse>> findAllArticles() {
    List<ArticleResponse> articles = blogService.findAll()
        .stream().map(ArticleResponse::new)
        .toList();

    return ResponseEntity.ok().body(articles);
  }

  @GetMapping("/api/articles/{id}")
  public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id){
    Article article = blogService.findById(id);

    return ResponseEntity.ok().body(new ArticleResponse(article));
  }

  @DeleteMapping("api/articles/{id}")
  public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
    blogService.delete(id);

    return ResponseEntity.ok().build();
  }

  @PatchMapping("/api/articles/{id}")
  public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody
      UpdateArticleRequest request) {
    Article updateArticle = blogService.update(id, request);

    return ResponseEntity.ok().body(updateArticle);
  }
}
