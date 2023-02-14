package tfip.ssf.ingredients_pos.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.data.redis.connection.RedisServer.INFO;
import org.springframework.stereotype.Service;

import tfip.ssf.ingredients_pos.Model.Ingredient;

@Service
public class IngredientService{
    
    // store the ingredients into a hashmap
    private List <Ingredient> ingredientList = new LinkedList<Ingredient>();
    private Map<String, Ingredient> ingredients = new HashMap<String, Ingredient>();

    // retrieve map (getAll)
    public Map<String, Ingredient> getAllMap(){

        if (ingredients == null){
            Map<String, Ingredient> allIngredients = new HashMap<String, Ingredient>(); 
            return allIngredients;
        } else {
            return ingredients;
        }
    }

    public List<Ingredient> getAllList(){
        
        return ingredientList;
    }


    // update map
    public void updateIngredient(Ingredient input){

        String name = input.getName();
        float price = input.getPrice();
        if (ingredients.containsKey(name)){
            // get new quantity
            int currentQuantity = ingredients.get(name).getAmount();
            int quantityChange = input.getAmount();
            int newQuantity = currentQuantity + quantityChange;
            // add a new Ingredient to the map with the new quantity
            Ingredient newIngredient = new Ingredient(name, newQuantity, price );
            ingredients.put(name, newIngredient);

            // havent include code to update list, will leave it for now

        } else {
            ingredients.put(name, input);
            ingredientList.add(input);
        }


    }

    // name
    public Ingredient findByName(String name){
        return ingredients.get(name);
    }
   
    

}
