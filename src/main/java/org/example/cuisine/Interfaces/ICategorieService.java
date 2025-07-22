package org.example.cuisine.Interfaces;

import org.example.cuisine.Model.Categorie;


import java.util.List;
import java.util.UUID;

public class ICategorieService {

    Categorie createCategorie(Categorie categorie);
    Categorie getCategorieById(UUID catid);
    List<Categorie> getAllCategories();
    Categorie updateCategorie(UUID id, Categorie categorie);
    void deleteCategorieById(UUID id);
}
