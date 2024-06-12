package com.dalton.backend.controller;

import com.dalton.backend.metierRelationnel.Produit;
import com.dalton.backend.metierRelationnel.Utilisateur;
import com.dalton.backend.metierServices.ProduitManager;
import com.dalton.backend.metierServices.UtilisateurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
public class SessionPasserCde {

    ProduitManager produitManager;
    private final UtilisateurManager utilisateurManager;
    @Autowired
    public SessionPasserCde(ProduitManager produitManager, UtilisateurManager utilisateurManager) {
        this.produitManager = produitManager;
        this.utilisateurManager = utilisateurManager;
    }

    @GetMapping
    public List<Produit> traiterAccesApplication(){
        List<Produit> produits = produitManager.rechercherProduitEstDuJour(true);
        return produits;
    }
    @PostMapping("/login")
    public ResponseEntity<Utilisateur> login(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurTrouve = utilisateurManager.findByEmailAndMotDePasse(utilisateur.getEmail(), utilisateur.getMotDePasse());
        if (utilisateurTrouve != null) {
            return ResponseEntity.ok(utilisateurTrouve);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
