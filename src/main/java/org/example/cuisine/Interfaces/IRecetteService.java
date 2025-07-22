package org.example.cuisine.Interfaces;

import org.example.cuisine.Model.Recette;

import java.util.List;
import java.util.UUID;

public class IRecetteService {
    Recette createRecette(Recette recette);
    Recette getRecetteById(UUID id);
    List<Recette> getAllRecettes();
    Recette updateRecette(UUID id, Recette recette);
    void deleteRecetteById(UUID id);
}
