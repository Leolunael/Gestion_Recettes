package org.example.cuisine.Interfaces;

import org.example.cuisine.Model.Categorie;
import java.util.List;
import java.util.UUID;

public interface ICategorieService {

    Categorie createCategorie(Categorie categorie);
    Categorie getCategorieById(UUID catId);
    List<Categorie> getAllCategories();
    Categorie updateCategorie(UUID catId, Categorie categorie);
    void deleteCategorieByCatId(UUID catId);
}
