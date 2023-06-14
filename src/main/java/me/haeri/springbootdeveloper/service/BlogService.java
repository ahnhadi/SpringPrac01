package me.haeri.springbootdeveloper.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.haeri.springbootdeveloper.dto.AddArticleRequest;
import me.haeri.springbootdeveloper.dto.UpdateArticleRequest;
import me.haeri.springbootdeveloper.entity.Article;
import me.haeri.springbootdeveloper.repository.BlogRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BlogService {

  private final BlogRepository blogRepository;

  // 블로그 글 추가 메서드
  public Article save(AddArticleRequest request, String userName){
    return blogRepository.save(request.toEntity(userName));
  }

  public List<Article> findAll(){
    return blogRepository.findAll();
  }

  public Article findById(Long id){
    return blogRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
  }

  public void delete(Long id) {
    Article article = blogRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found : "+ id));
    authorizeArticleAuthor(article);
    blogRepository.delete(article);
  }

  @Transactional
  public Article update(Long id, UpdateArticleRequest request){
    Article article = blogRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found : "+ id));

    authorizeArticleAuthor(article);
    article.update(request.getTitle(), request.getContent());

    return article;
  }

  // 게시글을 작성한 유저인지 확인
  private static void authorizeArticleAuthor(Article article){
    String userName = SecurityContextHolder.getContext().getAuthentication().getName();
    if (!article.getAuthor().equals(userName)) {
      throw new IllegalArgumentException("not authorized");
    }
  }
}
