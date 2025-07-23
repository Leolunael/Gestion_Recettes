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

    private Map<UUID, Recette> recettes;

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

        if(recette.getNom() != null && !recette.getNom().isBlank())
            recetteToUpdate.setName(recette.getName());

        return recettes.put(id, recetteToUpdate);
    }

    public void deleteRecetteById(UUID id) {
        recettes.remove(id);
    }
}
