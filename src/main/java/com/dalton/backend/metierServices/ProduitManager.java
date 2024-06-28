package com.dalton.backend.metierServices;

import com.dalton.backend.metierRelationnel.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitManager extends JpaRepository<Produit, String> {
        @Query("SELECT p FROM Produit p WHERE p.estDuJour = :estDuJour")
        List<Produit> rechercherProduitEstDuJour(@Param("estDuJour") boolean estDuJour);

        @Query("SELECT p.quantiteEnStock FROM Produit p WHERE p.reference = :reference")
        int findQuantiteEnStockByReference(@Param("reference") String reference);
}