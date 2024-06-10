package com.dalton.backend.metierServices;

import com.dalton.backend.metierRelationnel.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitManager extends JpaRepository<Produit, String> {
        @Query("select * from produit where estDuJour=:estDuJour")
        List<Produit> rechercherProduitDuJour(@Param("estDuJour") boolean estDuJour);
}