package tfip.ssf.ingredients_pos.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Ingredient {
    
    @NotEmpty (message="enter name")
    private String name;

    @NotNull (message="enter amount")
    private Integer amount;

    
    private float price;

    private String idName;
    

    public Ingredient() {
    }

    public Ingredient(String name, Integer amount, float price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    

}
