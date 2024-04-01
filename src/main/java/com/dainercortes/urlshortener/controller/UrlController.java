package com.dainercortes.urlshortener.controller;

import com.dainercortes.urlshortener.domain.url.DataRegisterUrl;
import com.dainercortes.urlshortener.domain.url.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UrlController {

    @Autowired
    private UrlService service;

    @GetMapping("/") String index() {
        return "index";
    }


    @PostMapping("/shorten")
    public String generateShortLink(@ModelAttribute DataRegisterUrl data, Model model) {
        service.generateShortLink(data);

        System.out.println(data.toString());
        String urll = "http://localhost:8080/" + service.findUrl(data.originalUrl());
        model.addAttribute("shortLink", urll);
        return "shortened";
    }

    @GetMapping("/{shortLink}")
    public RedirectView redirectToOriginalUrl(@PathVariable String shortLink) {
        var response = service.getEncodedUrl(shortLink);
        return new RedirectView(response.shortLink());
    }

}
