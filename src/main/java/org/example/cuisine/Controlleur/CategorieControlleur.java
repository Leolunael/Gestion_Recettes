package org.example.cuisine.Controlleur;

import ch.qos.logback.core.model.Model;
import org.example.cuisine.Interfaces.ICategorieService;
import org.example.cuisine.Interfaces.IRecetteService;
import org.example.cuisine.Model.Categorie;
import org.example.cuisine.Model.Recette;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class CategorieControlleur {

    private ICategorieService categorieService;

    public CategorieControlleur(ICategorieService categorieService) {

        this.categorieService = categorieService;
    }

    // http://localhost:8080/home
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    // http://localhost:8080/register
    @GetMapping("/register")
    public String addCategorie(Model model){
        model.addAttribute("categorie", new Categorie());
        return "categorie/register";
    }

    // http://localhost:8080/list
    @GetMapping("/list")
    public String getAllCategories(Model model){
        List<Categorie> categories = categorieService.getAllCategories();
        model.addAttribute("categorie", categories);
        return "Categorie/categorieList";
    }


    // http://localhost:8080/update/ac96bc35-0bd1-4449-8730-fcd3082432d1 (attention exemple seulement)
    @GetMapping("/update/{id}")
    public String updateCategorie(@PathVariable UUID CatId, Model model){
        Categorie categorie = categorieService.getCategorieById(CatId);
        model.addAttribute("categorie", categorie);
        return "categorie/categorieUpdate";
    }

    @PostMapping("/register")
    public String addCategorie(Categorie categorie){
        if(categorie != null)
            categorieService.createCategorie(categorie);

        return "redirect:/list";
    }

    @PostMapping("/update")
    public String updateCategorie(Categorie categorie){
        if(categorie.getCatId() != null)
            categorieService.updateCategorie(categorie.getCatId(), categorie);

        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategorie(@PathVariable UUID CatId){
        categorieService.deleteCategorieById(CatId);
        return "redirect:/list";
    }
}
