package com.dainercortes.urlshortener.domain.url;

public record DataResponseEncodedUrl(String shortLink) {

    public DataResponseEncodedUrl(Url url) { this(url.getShortLink());}
}
