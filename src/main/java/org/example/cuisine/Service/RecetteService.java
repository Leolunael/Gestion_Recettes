package org.example.cuisine.Service;

import org.example.cuisine.Interfaces.IRecetteService;
import org.example.cuisine.Model.Recette;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RecetteService implements IRecetteService {

    private final Map<UUID, Recette> recettes;

    public RecetteService() {
        recettes = new HashMap<>();
        Recette recette = new Recette(UUID.randomUUID(),
                "Tapenade", "Olives confites dénoyautées, Anchois, Ail, Huile d'Olive",
                "Nettoyer les anchois, presser l'ail. Mettre tous les ingredients dans le mixeur. Mixer jusqu'à obtention de la texture souhaitée",
                "Apéritif");
        Recette recette2 = new Recette(UUID.randomUUID(), "Sauce au basilic",
                "Basilic, Feta, Jus de citron, Huile d'olives, Sel, Poivre ",
                "Mettre tous les ingrédients dans le mixeur. Mixer jusqu'à obtention dela texture souhaitée",
                "Apéritif");
        Recette recette3 = new Recette(UUID.randomUUID(), "Yaourt maison",
                "Lait entier, Ferments lactique",
                "Mettre tous les ingrédients dans le mixeur. Mixer jusqu'à l'apparition d'une mousse sur le lait. Remplir les pots. Les mettre dans la yaourtière. Programmer",
                "Dessert");
        recettes.put(recette.getId(), recette);
        recettes.put(recette2.getId(), recette2);
        recettes.put(recette3.getId(), recette3);
    }

    public Recette createRecette(Recette recette) {
        recette.setId(UUID.randomUUID());
        recettes.put(recette.getId(), recette);
        return recette;
    }

    public Recette getRecetteById(UUID id) {
        return recettes.get(id);
    }

    public List<Recette> getAllRecettes() {
        return recettes.values().stream().toList();
    }


    public Recette updateRecette(UUID id, Recette recette) {
        Recette recetteToUpdate = recettes.get(id);
        if(recetteToUpdate == null)
            return null;

        if(!recette.getNom().isBlank())
            recetteToUpdate.setNom(recette.getNom());

        if(!recette.getIngredient().isBlank())
            recetteToUpdate.setIngredient(recette.getIngredient());

        if(!recette.getInstructions().isBlank())
            recetteToUpdate.setInstructions(recette.getInstructions());

        if(!recette.getName().isBlank())
            recetteToUpdate.setName(recette.getName());

        return recettes.put(id, recetteToUpdate);
    }

    public void deleteRecetteById(UUID id) {
        recettes.remove(id);
    }
}
