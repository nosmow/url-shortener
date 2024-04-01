package com.dainercortes.urlshortener.domain.url;

import com.dainercortes.urlshortener.infra.errors.IntegrityValidation;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public DataResponseEncodedUrl generateShortLink(DataRegisterUrl data) {
        validateUrlInsert(data.originalUrl());

        if (urlRepository.existsByOriginalUrl(data.originalUrl())) {
            Url url = urlRepository.findByOriginalUrl(data.originalUrl());
            return new DataResponseEncodedUrl(url.getShortLink());
        } else {
            String encodedUrl = encodedUrl(data.originalUrl());
            Url url = new Url(data.originalUrl(), encodedUrl);
            urlRepository.save(url);
            return new DataResponseEncodedUrl(encodedUrl);
        }
    }

    private String encodedUrl(String url) {
        String encodedUrl = "";
        do {
            encodedUrl = Hashing.murmur3_32()
                    .hashString(url, StandardCharsets.UTF_8)
                    .toString();
        } while (urlRepository.existsByShortLink(encodedUrl));

        return encodedUrl;
    }

    public String findUrl(String originalUrl) {
        Url url = urlRepository.findByOriginalUrl(originalUrl);

        return url.getShortLink();
    }

    public DataResponseDecodedUrl getEncodedUrl(String shortLink) {
        validateUrlInsert(shortLink);
        Url url = urlRepository.findByShortLink(shortLink);
        return new DataResponseDecodedUrl(url);
    }

    private void validateUrlInsert(String url) {
        if (!StringUtils.isNotEmpty(url)) {
            throw new IntegrityValidation("Url Empty");
        }
    }
}
