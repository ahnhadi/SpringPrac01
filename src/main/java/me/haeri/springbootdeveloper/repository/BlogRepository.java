package me.haeri.springbootdeveloper.repository;

import me.haeri.springbootdeveloper.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
