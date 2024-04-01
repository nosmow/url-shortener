package com.dainercortes.urlshortener.domain.url;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
    public Url findByShortLink(String shortLink);
    public Url findByOriginalUrl(String originalUrl);
    boolean existsByShortLink(String shortLink);
    boolean existsByOriginalUrl(String originalUrl);
}
