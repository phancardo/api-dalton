package com.dalton.backend.metierServices;

import com.dalton.backend.metierRelationnel.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurManager extends JpaRepository<Utilisateur, Long> {
    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :motDePasse")
    Utilisateur findByEmailAndMotDePasse(@Param("email") String email, @Param("motDePasse") String motDePasse);
}
