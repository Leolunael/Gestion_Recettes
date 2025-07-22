package org.example.cuisine.Controlleur;


import ch.qos.logback.core.model.Model;
import org.example.cuisine.Interfaces.IRecetteService;
import org.example.cuisine.Model.Recette;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class RecetteControlleur {

    private IRecetteService recetteService;

    public RecetteControlleur(IRecetteService recetteService) {

        this.recetteService = recetteService;
    }

    // http://localhost:8080/home
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    // http://localhost:8080/addrecette
    @GetMapping("/addrecette")
    public String addRecette(Model model){
        model.addAttribute("recette", new Recette());
        return "recette/addrecette";
    }

    // http://localhost:8080/listrecette
    @GetMapping("/listrecette")
    public String getAllRecettes(Model model){
        List<Recette> recettes = recetteService.getAllRecettes();
        model.addAttribute("recettes", recettes);
        return "recette/recetteList";
    }


    // http://localhost:8080/update/ac96bc35-0bd1-4449-8730-fcd3082432d1 (attention exemple seulement)
    @GetMapping("/update/{id}")
    public String updateRecette(@PathVariable UUID id, Model model){
        Recette recette = recetteService.getRecetteById(id);
        model.addAttribute("recette", recette);
        return "recette/recetteUpdate";
    }

    @PostMapping("/addrecette")
    public String addRecette(Recette recette){
        if(recette != null)
            recetteService.createRecette(recette);

        return "redirect:/listrecette";
    }

    @PostMapping("/updaterecette")
    public String updateRecette(Recette recette){
        if(recette.getId() != null)
            recetteService.updateRecette(recette.getId(), recette);

        return "redirect:/listrecette";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecette(@PathVariable UUID id){
        recetteService.deleteRecetteById(id);
        return "redirect:/listrecette";
    }
}
