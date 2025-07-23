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

public class Categorie {
    private UUID catId;
    @NotNull (message = "Merci de mettre un nom!")
    @NotBlank
    private String name;
    private String description;


}
