package tfip.ssf.ingredients_pos.Controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Lists;

import jakarta.validation.Valid;
import tfip.ssf.ingredients_pos.Model.Ingredient;
import tfip.ssf.ingredients_pos.Service.IngredientService;

@Controller
public class IngredientController {

    @Autowired
    private IngredientService ingdSvc;
    
    @GetMapping("/add")
    public String addIngredient(Model model){

        model.addAttribute("ingredient", new Ingredient());
        
        return "inputform";
    }

    @PostMapping("/ingredient")
    public String postAdd(@Valid Ingredient ingredient, BindingResult result, Model model){
    //public String postAdd(){  
        if(result.hasErrors()){
            return "inputform";
        }
        
        ingdSvc.updateIngredient(ingredient);
        System.out.println(Arrays.asList(ingdSvc.getAllMap()));
        model.addAttribute("ingredient", ingredient);
        
        return "ingredientAdded";
    }

    @GetMapping("/")
    public String showAll(Model model){
        
        List<Ingredient> ingredientList = ingdSvc.getAllList();
        
        //Map <String, Ingredient> allIngredients = ingdSvc.getAllMap();
        // allIngredients.forEach((key, value)
        // -> ingredientList.add(value));
    
        //System.out.println(Arrays.asList(allIngredients));
        //System.out.println(Arrays.asList(ingdSvc.showAllIngredients()));
        model.addAttribute("all", ingredientList);

        //list
        return "list";
    }

    @GetMapping(path = "/ingredient/{ingredientname}")
    public String getIngredient (Model model, @PathVariable(value = "ingredientname") String ingredientname){
        
        Ingredient ingred = ingdSvc.findByName(ingredientname);
        //System.out.println(ctc.getId());
        //ctc.setId(contactId);
        model.addAttribute("ingredientInfo", ingred);
        return "ingredientInfo";

    }
}
