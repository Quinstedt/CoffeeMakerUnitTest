package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory1;

    private Recipe recipe1;
    private Recipe recipe2;

    private final String inventoryFailMessage = "InventoryException should not be thrown!";
    private final String recipeFailMessage = "RecipeException should not be thrown!";


    @Before
    public void setUp() {
        inventory1 = new Inventory();

        // inventory2 will be used to confirm that the object is static
        // the sequence to test: create inventory1, add to inventory1, create inventory2, check if inventory2 values are the default ones(15)
        try{
            recipe1 = new Recipe();
            recipe1.setName("Recipe1");
            recipe1.setAmtChocolate("1");
            recipe1.setAmtCoffee("1");
            recipe1.setAmtMilk("1");
            recipe1.setAmtSugar("1");
            recipe1.setPrice("50");

            recipe2 = new Recipe();
            recipe2.setName("Recipe2");
            recipe2.setAmtChocolate("30");
            recipe2.setAmtCoffee("30");
            recipe2.setAmtMilk("30");
            recipe2.setAmtSugar("30");
            recipe2.setPrice("50");

        }catch(RecipeException e) {
            fail(recipeFailMessage);
        }
    }

    /**
     **** Tests for getters of all attributes in the Inventory class (I1-I4) ****
     */

    /**
     *  @Test ID: I1
     */
    @Test
    public void testGetChocolate(){
        assertEquals(15, inventory1.getChocolate());
    }

    /**
     *  @Test ID: I2
     */
    @Test
    public void testGetCoffee(){
        assertEquals(15, inventory1.getCoffee());
    }

    /**
     *  @Test ID: I3
     */
    @Test
    public void testGetMilk(){
        assertEquals(15, inventory1.getMilk());
    }

    /**
     *  @Test ID: I4
     */
    @Test
    public void testGetSugar(){
        assertEquals(15, inventory1.getSugar());
    }

    /**
     **** Tests for methods that involve chocolate attribute (I5-I9) ****
     */

    /**
     *  @Test ID: I5
     */
    @Test
    public void testSetChocolatePositiveInt(){
        inventory1.setChocolate(2);
        assertEquals(2, inventory1.getChocolate());
    }

    /**
     *  @Test ID: I6
     */
    @Test
    public void testSetChocolateNegativeInt(){
        inventory1.setChocolate(-1);
        assertEquals(15, inventory1.getChocolate());
    }

    /**
     *  @Test ID: I7
     */
    @Test
    public void testAddChocolate(){
        try{
            inventory1.addChocolate("3");
            assertEquals(18,inventory1.getChocolate());
        } catch(InventoryException e) {
            fail(inventoryFailMessage);
        }
    }

    /**
     *  @Test ID: I8
     */
    @Test
    public void testAddChocolateNegativeValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addChocolate("-1");
                }
        );
    }

    /**
     *  @Test ID: I9
     */
    @Test
    public void testAddChocolateInvalidStringValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addChocolate("2.5");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addChocolate("x");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addChocolate("");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addChocolate(null);
                }
        );
    }

    /**
     **** Tests for methods that involve coffee attribute (I10-I14) ****
     */


    /**
     *  @Test ID: I10
     */
    @Test
    public void testSetCoffeePositiveInt(){
        inventory1.setCoffee(2);
        assertEquals(2, inventory1.getCoffee());
    }

    /**
     *  @Test ID: I11
     */
    @Test
    public void testSetCoffeeNegativeInt(){
        inventory1.setCoffee(-1);
        assertEquals(15, inventory1.getCoffee());
    }

    /**
     *  @Test ID: I12
     */
    @Test
    public void testAddCoffee(){
        try{
            inventory1.addCoffee("3");
            assertEquals(18,inventory1.getCoffee());
        } catch(InventoryException e) {
            fail(inventoryFailMessage);
        }
    }

    /**
     *  @Test ID: I13
     */
    @Test
    public void testAddCoffeeNegativeValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addCoffee("-1");
                }
        );
    }


    /**
     *  @Test ID: I14
     */
    @Test
    public void testAddCoffeeInvalidStringValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addCoffee("2.5");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addCoffee("x");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addCoffee("");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addCoffee(null);
                }
        );
    }

    /**
     **** Tests for methods that involve milk attribute (I15-I19) ****
     */

    /**
     *  @Test ID: I15
     */
    @Test
    public void testSetMilkPositiveInt(){
        inventory1.setMilk(2);
        assertEquals(2, inventory1.getMilk());
    }

    /**
     *  @Test ID: I16
     */
    @Test
    public void testSetMilkNegativeInt(){
        inventory1.setMilk(-1);
        assertEquals(15, inventory1.getMilk());
    }

    /**
     *  @Test ID: I17
     */
    @Test
    public void testAddMilk(){
        try{
            inventory1.addMilk("3");
            assertEquals(18,inventory1.getMilk());
        } catch(InventoryException e) {
            fail(inventoryFailMessage);
        }
    }

    /**
     *  @Test ID: I18
     */
    @Test
    public void testAddMilkNegativeValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addMilk("-1");
                }
        );
    }

    /**
     *  @Test ID: I19
     */
    @Test
    public void testAddMilkInvalidStringValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addMilk("2.5");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addMilk("x");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addMilk("");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addMilk(null);
                }
        );
    }

    /**
     **** Tests for methods that involve sugar attribute (I20-I24) ****
     */

    /**
     *  @Test ID: I20
     */
    @Test
    public void testSetSugarPositiveInt(){
        inventory1.setSugar(2);
        assertEquals(2, inventory1.getSugar());
    }

    /**
     *  @Test ID: I21
     */
    @Test
    public void testSetSugarNegativeInt(){
        inventory1.setSugar(-1);
        assertEquals(15, inventory1.getSugar());
    }

    /**
     *  @Test ID: I22
     */
    @Test
    public void testAddSugar(){
        try{
            inventory1.addSugar("3");
            assertEquals(18, inventory1.getSugar());
        } catch(InventoryException e) {
            fail(inventoryFailMessage);
        }
    }
    /**
     *  @Test ID: I23
     */
    @Test
    public void testAddSugarNegativeValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addSugar("-1");
                }
        );
    }
    /**
     *  @Test ID: I24
     */
    @Test
    public void testAddSugarInvalidStringValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addSugar("2.5");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addSugar("x");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addSugar("");
                }
        );
        assertThrows(
                InventoryException.class, () -> {
                    inventory1.addSugar(null);
                }
        );
    }
    /**
     **** Tests for methods that involve all attribute (I25-I) ****
     */

    /**
     *  @Test ID: I25
     */
    @Test
    public void testEnoughIngredients(){
        assertEquals(true,inventory1.enoughIngredients(recipe1));
    }

    /**
     *  @Test ID: I26
     */
    @Test
    public void testNotEnoughIngredients(){
        assertEquals(false,inventory1.enoughIngredients(recipe2));
    }

    /**
     *  @Test ID: I27
     */
    @Test
    public void testUseIngredientsEnoughInventory(){
        Recipe recipe3 = new Recipe();
        try{
            recipe3.setName("Recipe3");
            recipe3.setAmtChocolate("10");
            recipe3.setAmtCoffee("10");
            recipe3.setAmtMilk("10");
            recipe3.setAmtSugar("10");
            recipe3.setPrice("50");

        }catch(RecipeException e) {
            fail(recipeFailMessage);
        }

        //Inventory inventory = new Inventory();

        assertEquals(true, inventory1.useIngredients(recipe3));

        inventory1.useIngredients(recipe3);

        assertEquals(5,inventory1.getChocolate());
        assertEquals(5,inventory1.getCoffee());
        assertEquals(5,inventory1.getMilk());
        assertEquals(5,inventory1.getSugar());
    }

    /**
     *  @Test ID: I28
     */
    @Test
    public void testUseIngredientsNotEnoughInventory(){
        Recipe recipe4 = new Recipe();

        try{
            recipe4.setName("Recipe2");
            recipe4.setAmtChocolate("30");
            recipe4.setAmtCoffee("30");
            recipe4.setAmtMilk("30");
            recipe4.setAmtSugar("30");
            recipe4.setPrice("50");
        }catch(RecipeException e) {
            fail(recipeFailMessage);
        }

        assertEquals(false, inventory1.useIngredients(recipe4));

        inventory1.useIngredients(recipe4);

        assertEquals(15,inventory1.getChocolate());
        assertEquals(15,inventory1.getCoffee());
        assertEquals(15,inventory1.getMilk());
        assertEquals(15,inventory1.getSugar());
    }

    /**
     *  @Test ID: I29
     */
    @Test
    public void testToString(){
        String inventoryToString = "Coffee: " + "15" + "\n" + "Milk: " + "15" + "\n" +
                "Sugar: " + "15" + "\n" + "Chocolate: " + "15" + "\n";

        assertEquals(inventoryToString, inventory1.toString());
    }

    /**
     *  @Test ID: I30
     */
    @Test
    public void testCreateInventory(){
        Inventory inventory = new Inventory();
        assertEquals(15,inventory.getChocolate());
        assertEquals(15,inventory.getCoffee());
        assertEquals(15,inventory.getMilk());
        assertEquals(15,inventory.getSugar());
    }

    /**
     *  @Test ID: I31
     */
    @Test
    public void testInventoryIsStatic(){
        Inventory inventory2 = new Inventory();

        assertEquals(15,inventory2.getChocolate());
        assertEquals(15,inventory2.getCoffee());
        assertEquals(15,inventory2.getMilk());
        assertEquals(15,inventory2.getSugar());

        inventory2.setChocolate(1);
        inventory2.setCoffee(1);
        inventory2.setMilk(1);
        inventory2.setSugar(1);

        assertEquals(1,inventory1.getChocolate());
        assertEquals(1,inventory1.getCoffee());
        assertEquals(1,inventory1.getMilk());
        assertEquals(1,inventory1.getSugar());

    }



}