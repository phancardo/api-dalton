package com.dalton.backend.controller;

import com.dalton.backend.metierRelationnel.Produit;
import com.dalton.backend.metierServices.ProduitManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
public class SessionPasserCde {

    ProduitManager produitManager;
    @Autowired
    public SessionPasserCde(ProduitManager produitManager) {
        this.produitManager = produitManager;
    }

    @GetMapping
    public List<Produit> traiterAccesApplication(){
        List<Produit> produits = produitManager.rechercherProduitEstDuJour(true);
        return produits;
    }
}
