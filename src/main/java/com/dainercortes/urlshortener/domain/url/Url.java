package com.dainercortes.urlshortener.domain.url;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "url")
@Entity(name = "Url")
@Getter
@EqualsAndHashCode(of = "id")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String originalUrl;
    private String shortLink;

    public Url() {

    }
    public Url(String originalUrl, String shortLink) {
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
    }
}
