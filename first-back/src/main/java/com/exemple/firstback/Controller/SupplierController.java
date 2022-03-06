package com.exemple.firstback.Controller;

import com.exemple.firstback.Entity.Supplier;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
    @Autowired
    private KeycloakRestTemplate keycloakRestTemplate;

    @GetMapping("/suppliers")
    public String index(Model model) {
        ResponseEntity<PagedModel<Supplier>>
                response = keycloakRestTemplate.exchange(
                "http://localhost:8083/suppliers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PagedModel<Supplier>>() {
                });

        model.addAttribute("suppliers", response.getBody().getContent());

        //To Show Token
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal<KeycloakSecurityContext>) authentication.getPrincipal();
        String token = principal.getKeycloakSecurityContext().getTokenString();
        System.out.println(token);
        return "suppliers";
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler() {
        return "errors";
    }

}
