package com.dainercortes.urlshortener.domain.url;

import jakarta.validation.constraints.NotBlank;

public record DataRegisterUrl(
        @NotBlank
        String originalUrl,
        @NotBlank
        String shortLink
) {

}
