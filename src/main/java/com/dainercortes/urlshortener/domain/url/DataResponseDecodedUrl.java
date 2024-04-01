package com.dainercortes.urlshortener.domain.url;

public record DataResponseDecodedUrl(String shortLink) {

    public DataResponseDecodedUrl(Url url) { this(url.getOriginalUrl());}
}
