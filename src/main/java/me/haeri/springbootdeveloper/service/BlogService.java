package me.haeri.springbootdeveloper.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.haeri.springbootdeveloper.dto.AddArticleRequest;
import me.haeri.springbootdeveloper.entity.Article;
import me.haeri.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

  private final BlogRepository blogRepository;

  // 블로그 글 추가 메서드
  public Article save(AddArticleRequest request){
    return blogRepository.save(request.toEntity());
  }

  public List<Article> findAll(){
    return blogRepository.findAll();
  }
}
