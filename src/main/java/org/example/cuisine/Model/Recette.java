package org.example.cuisine.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recette {
    private UUID id;
    @NotNull (message = "Il faut le nom de la recette")
    @NotBlank
    private String nom;
    private String ingredient;
    private String instructions;
    private Categorie name;
}
