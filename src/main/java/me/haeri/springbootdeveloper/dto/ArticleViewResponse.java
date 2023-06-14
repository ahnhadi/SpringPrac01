package me.haeri.springbootdeveloper.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.haeri.springbootdeveloper.entity.Article;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {

  private Long id;
  private String author;
  private String title;
  private String content;
  private LocalDateTime createdAt;

  public ArticleViewResponse(Article article){
    this.id = article.getId();
    this.author = article.getAuthor();
    this.title = article.getTitle();
    this.content = article.getContent();
    this.createdAt = article.getCreatedAt();
  }
}
