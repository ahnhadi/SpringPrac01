package me.haeri.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.haeri.springbootdeveloper.entity.RefreshToken;
import me.haeri.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

  private final RefreshTokenRepository refreshTokenRepository;

  public RefreshToken findByRefreshToken(String refreshToken){
    return refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
  }
}
