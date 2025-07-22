package org.example.cuisine.Service;

import org.example.cuisine.Interfaces.ICategorieService;
import org.example.cuisine.Model.Categorie;
import org.example.cuisine.Model.Recette;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CategorieService implements ICategorieService {

    private final Map<UUID, Categorie> categories;

    public CategorieService() {
        categories = new HashMap<>();
        Categorie categorie = new Categorie(UUID.randomUUID(), "Apéritif", "Pour un moment convivial");
        Categorie categorie2 = new Categorie(UUID.randomUUID(), "Plat Mijoté", "Pour un moment convivial en famille");
        categories.put(categorie.getCatId(), categorie);
        categories.put(categorie2.getCatId(), categorie2);

    }

    public Categorie createCategorie(Categorie categorie) {
        categorie.setCatId(UUID.randomUUID());
        categories.put(categorie.getCatId(), categorie);
        return categorie;
    }

    public Categorie getCategorieById(UUID CatId) {
        return categories.get(CatId);
    }

    public List<Categorie> getAllCategories() {
        return categories.values().stream().toList();
    }    public Categorie updateCategorie(UUID CatId, Categorie categorie) {
        Categorie categorieToUpdate = categories.get(CatId);
        if(categorieToUpdate == null)
            return null;

        if(!categorie.getName().isBlank())
            categorieToUpdate.setName(categorie.getName());

        if(!categorie.getDescription().isBlank())
            categorieToUpdate.setDescription(categorie.getDescription());

        return categories.put(CatId, categorieToUpdate);
    }

    public void deleteCategorieByCatId(UUID CatId) {
        categories.remove(CatId);
    }
}
