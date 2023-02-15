package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerTest {

    private Recipe recipe;
    private Recipe recipe2;

    private int change;
    private int amtPaid;

    private CoffeeMaker coffeeMaker;
    private Inventory inventory;
    private RecipeBook testRecipeBook;

    private final String recipeExceptionFailMessage = "RecipeException should not be thrown";
    private final String inventoryExceptionFailMessage = "InventoryException should not be thrown";


    @Before
    public void setUp(){
        coffeeMaker = new CoffeeMaker();
        testRecipeBook = new RecipeBook();
        inventory = new Inventory();
        change = 0;
        amtPaid = 0;

        try{
            recipe = new Recipe();
            recipe.setName("Recipe1");
            recipe.setAmtChocolate("2");
            recipe.setAmtCoffee("4");
            recipe.setAmtMilk("1");
            recipe.setAmtSugar("5");
            recipe.setPrice("50");

            recipe2 = new Recipe();

        } catch (RecipeException e){
            System.out.println(e.getMessage());
        }


    }

    /**
     *  @Test ID: CM1
     */
    @Test
    public void testGetRecipe(){
        coffeeMaker.addRecipe(recipe);
        coffeeMaker.addRecipe(recipe2);
        testRecipeBook.getRecipes()[0] = recipe;
        testRecipeBook.getRecipes()[1] = recipe2;
        assertArrayEquals(testRecipeBook.getRecipes(), coffeeMaker.getRecipes());
    }

    /**
     *  @Test ID: CM2
     */
    @Test
    public void testAddRecipe(){
        assertTrue(coffeeMaker.addRecipe(recipe));
        testRecipeBook.getRecipes()[0] = recipe;
        assertArrayEquals(testRecipeBook.getRecipes(), coffeeMaker.getRecipes());

    }

    /**
     *  @Test ID: CM3
     */
    @Test
    public void testDeleteRecipe(){
        coffeeMaker.addRecipe(recipe);
        //check that the return message is the correct one
        assertEquals(recipe.getName(),coffeeMaker.deleteRecipe(0));
        // check that the recipe is not the same as before deletion
        assertNotSame(recipe, coffeeMaker.getRecipes()[0]);
        // checking that the recipe is actually null after the deletion
        assertNull(coffeeMaker.getRecipes()[0]);
    }

    /**
     *  @Test ID: CM4
     */
    @Test
    public void testEditRecipe() {
        coffeeMaker.addRecipe(recipe);

        try {
            recipe2.setName("newRecipe");
            recipe2.setAmtCoffee("3");
            recipe2.setPrice("50");
            recipe2.setAmtChocolate("4");
            recipe2.setAmtSugar("2");
            recipe2.setAmtMilk("3");
            coffeeMaker.editRecipe(0, recipe2);

            testRecipeBook.getRecipes()[0] = recipe2;
            System.out.println(testRecipeBook.getRecipes()[0].getName() + " :  "+ coffeeMaker.getRecipes()[0].getName());
            assertSame(testRecipeBook.getRecipes()[0], coffeeMaker.getRecipes()[0]);
            assertArrayEquals(testRecipeBook.getRecipes(), coffeeMaker.getRecipes());
        } catch (RecipeException e) {
            fail(recipeExceptionFailMessage);
        }
    }
    /**
     *  @Test ID: CM5
     */
    @Test
    public void testCheckInventory(){
        String inventoryToString = "Coffee: " + "15" + "\n" + "Milk: " + "15" + "\n" +
                "Sugar: " + "15" + "\n" + "Chocolate: " + "15" + "\n";

        assertEquals(inventoryToString, coffeeMaker.checkInventory());
    }

    /**
     *  @Test ID: CM6
     */
    @Test
    public void testAddInventory(){
        try {
            coffeeMaker.addInventory("35","35","35","35");
        }catch (InventoryException e){
            fail(inventoryExceptionFailMessage);
        }

        String inventoryToString = "Coffee: " + "50" + "\n" + "Milk: " + "50" + "\n" +
                "Sugar: " + "50" + "\n" + "Chocolate: " + "50" + "\n";
        assertEquals(inventoryToString, coffeeMaker.checkInventory());
    }

    /**
     *  @Test ID: CM7
     */
    @Test
    public void testAddInventoryWithZero() {
        try {
            coffeeMaker.addInventory("0", "0", "0", "0");
        }
        catch (InventoryException e){
            fail(inventoryExceptionFailMessage);
        }
        String inventoryToString = "Coffee: " + "15" + "\n" + "Milk: " + "15" + "\n" +
                "Sugar: " + "15" + "\n" + "Chocolate: " + "15" + "\n";

        assertEquals(inventoryToString, coffeeMaker.checkInventory());
    }


    /**
     *  @Test ID: CM8
     */
    @Test
    public void testAddInventoryOnlyOneValidValueRestAreEmpty() {
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("50","","",""));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("","50","",""));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("","","50",""));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("","","","50"));
    }

    /**
     *  @Test ID: CM9
     */
    @Test
    public void testAddInventoryOneNullValue() {
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory(null, "50", "50", "50"));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("50", null, "50", "50"));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("50", "50", null, "50"));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("50", "50", "50", null));
    }

    /**
     *  @Test ID: CM10
     */
    @Test
    public void testAddInventoryNegativeValues(){
        // All Negative values
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("-1","-1","-1","-1"));
        // One negative value
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("-1","50","50","50"));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("50","-1","50","50"));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("50","50","-1","50"));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory( "50","50","50","-1"));

    }


    /**
     *  @Test ID: CM11
     */
    @Test
    public void testAddInventoryEmptyValues() {
        // All char
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("a","-a","a","a"));
        // One char
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("a","50","50","50"));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("50","a","50","50"));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("50","50","a","50"));
        assertThrows(InventoryException.class, () -> coffeeMaker.addInventory( "50","50","50","a"));
    }

    /**
     *  @Test ID: CM12
     */
    @Test
    public void testMakeCoffee(){
        coffeeMaker.addRecipe(recipe);
        amtPaid = 100;
        change = amtPaid - recipe.getPrice();
        assertEquals(change, coffeeMaker.makeCoffee(0, amtPaid));
    }

    /**
     *  @Test ID: CM13
     */
    @Test
    public void testMakeCoffeeRecipeDontExist(){
        amtPaid = 100;
        assertEquals(amtPaid, coffeeMaker.makeCoffee(0, amtPaid));
    }

    /**
     *  @Test ID: CM14
     */
    @Test
    public void testMakeCoffeeAmtPaidLessThanPrice(){
        coffeeMaker.addRecipe(recipe);
        amtPaid = 10;
        assertEquals(amtPaid, coffeeMaker.makeCoffee(0, amtPaid));
    }

    /**
     *  @Test ID: CM15
     */
    @Test
    public void testMakeCoffeeNegativeAmtPaid(){
        coffeeMaker.addRecipe(recipe);
        amtPaid = -5;
        assertEquals(0, coffeeMaker.makeCoffee(0, amtPaid));
    }

    /**
     *  @Test ID: CM16
     */
    @Test
    public void testMakeCoffeeInvalidRecipeIndex(){
        coffeeMaker.addRecipe(recipe);
        amtPaid = 100;
        assertEquals(amtPaid,coffeeMaker.makeCoffee(4,amtPaid));
    }

    /**
     *  @Test ID: CM17
     */
    @Test
    public void testMakeCoffeeEmptyInventory(){
        coffeeMaker.addRecipe(recipe);
        inventory.setChocolate(0);
        inventory.setCoffee(0);
        inventory.setMilk(0);
        inventory.setSugar(0);

        amtPaid = 100;;
        change = amtPaid - recipe.getPrice();
        assertEquals(amtPaid, coffeeMaker.makeCoffee(0, amtPaid));

    }


}
