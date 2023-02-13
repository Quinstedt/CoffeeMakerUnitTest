package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecipeTest {

    private Recipe recipe;
    Recipe recipe2;
    Throwable exception;
    String recipeExceptionFailMessage = "RecipeException should not be thrown";


    @Before
    public void setUp() throws Exception {
        recipe = new Recipe();
        recipe.setName("Recipe1");
        recipe.setAmtChocolate("2");
        recipe.setAmtCoffee("4");
        recipe.setAmtMilk("1");
        recipe.setAmtSugar("5");
        recipe.setPrice("50");

        recipe2 = new Recipe();
        recipe2.setName("Recipe1");
        recipe2.setAmtChocolate("2");
        recipe2.setAmtCoffee("4");
        recipe2.setAmtMilk("1");
        recipe2.setAmtSugar("5");
        recipe2.setPrice("50");

    }

/**
            **** Test Chocolate attribute set and get functions ****
 */

    /**
     *  @Test ID: R1
     */
    @Test
    public void testGetAmtChocolate(){
        assertEquals(2, recipe.getAmtChocolate());
    }
    /**
     *  @Test ID: R2
     */
    @Test
    public void testSetAmtChocolate(){
        try{
            recipe.setAmtChocolate("1");
            assertEquals(1, recipe.getAmtChocolate());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }
    }

    /**
     *  @Test ID: R3
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtChocolatePositiveInt(){
        try{
            recipe.setAmtChocolate(2 + "");
            assertEquals(2, recipe.getAmtChocolate());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }
    }

    /**
     *  @Test ID: R4
     */
    @Test
    public void testSetAmtChocolateNegativeValue(){
        exception = assertThrows(
          RecipeException.class, () -> {
              recipe.setAmtChocolate("-1");
          }
        );
    }

    /**
     *  @Test ID: R5
     */
    @Test
    public void testSetAmtChocolateToADoubleValue(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtChocolate("1.5");
                }
        );
    }

    /**
     *  @Test ID: R6
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtChocolateNegativeInt(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtChocolate(-1 + "");
                }
        );
    }
    /**
     *  @Test ID: R7
     */
    @Test
    public void testSetAmtChocolateToChar(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtChocolate("a");
                }
        );
    }
    /**
     *  @Test ID: R8
     */
    @Test
    public void testSetAmtChocolateToEmpty(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtChocolate("");
                }
        );
    }

/**
            **** Test Coffee attribute set and get functions  ****
 */


    /**
     *  @Test ID: R9
     */
    @Test
    public void testGetAmtCoffee(){
        assertEquals(4, recipe.getAmtCoffee());
    }
    /**
     *  @Test ID: R10
     */
    @Test
    public void testSetAmtCoffee(){
        try{
            recipe.setAmtCoffee("2");
            assertEquals(2, recipe.getAmtCoffee());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }
    }

    /**
     *  @Test ID: R11
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtCoffeePositiveInt(){
        try{
            recipe.setAmtCoffee(4 + "");
            assertEquals(4, recipe.getAmtCoffee());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }
    }

    /**
     *  @Test ID: R12
     */
    @Test
    public void testSetAmtCoffeeNegativeValue(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("-1");
                }
        );
    }
    /**
     *  @Test ID: R13
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtCoffeeNegativeInt(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee(-1 + "");
                }
        );
    }
    /**
     *  @Test ID: R14
     */
    @Test
    public void testSetAmtCoffeeToChar(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("a");
                }
        );
    }
    /**
     *  @Test ID: R15
     */
    @Test
    public void testSetAmtCoffeeToEmpty(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("");
                }
        );
    }

/**
            **** Test Milk attribute set and get functions  ****
 */

    /**
     *  @Test ID: R16
     */
    @Test
    public void testGetAmtMilk(){
        assertEquals(1, recipe.getAmtMilk());
    }
    /**
     *  @Test ID: R17
     */
    @Test
    public void testSetAmtMilk(){
        try{
            recipe.setAmtMilk("1");
            assertEquals(1, recipe.getAmtMilk());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }
    }

    /**
     *  @Test ID: R18
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtMilkPositiveInt(){
        try{
            recipe.setAmtMilk(2 + "");
            assertEquals(2, recipe.getAmtMilk());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }
    }

    /**
     *  @Test ID: R19
     */
    @Test
    public void testSetAmtMilkNegativeValue(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("-1");
                }
        );
    }

    /**
     *  @Test ID: R20
     */
    @Test
    public void testSetAmtMilkToADoubleValue(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("1.5");
                }
        );
    }

    /**
     *  @Test ID: R21
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtMilkNegativeInt(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk(-1 + "");
                }
        );
    }
    /**
     *  @Test ID: R22
     */
    @Test
    public void testSetAmtMilkToChar(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("a");
                }
        );
    }
    /**
     *  @Test ID: R23
     */
    @Test
    public void testSetAmtMilkToEmpty(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("");
                }
        );
    }


/**
            **** Test Sugar attribute set and get functions  ****
 */

    /**
     *  @Test ID: R24
     */
    @Test
    public void testGetAmtSugar(){
        assertEquals(5, recipe.getAmtSugar());
    }
    /**
     *  @Test ID: R25
     */
    @Test
    public void testSetAmtSugar(){
        try{
            recipe.setAmtSugar("1");
            assertEquals(1, recipe.getAmtSugar());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage); // Question should I use fail() like this?
        }
    }

    /**
     *  @Test ID: R26
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtSugarPositiveInt(){
        try{
            recipe.setAmtSugar(2 + "");
            assertEquals(2, recipe.getAmtSugar());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }
    }

    /**
     *  @Test ID: R27
     */
    @Test
    public void testSetAmtSugarNegativeValue(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("-1");
                }
        );
    }

    /**
     *  @Test ID: R28
     */
    @Test
    public void testSetAmtSugarDoubleValue(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("1.5");
                }
        );
    }

    /**
     *  @Test ID: R29
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtSugarNegativeInt(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar(-1 + "");
                }
        );
    }
    /**
     *  @Test ID: R30
     */
    @Test
    public void testSetAmtSugarToChar(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("a");
                }
        );
    }
    /**
     *  @Test ID: R31
     */
    @Test
    public void testSetAmtSugarToEmpty(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("");
                }
        );
    }

/**
             **** Test Name attribute ****
 */

    /**
     *  @Test ID: R32
     */
    @Test
    public void testGetName(){
        assertEquals("Recipe1", recipe.getName());
    }
    /**
     *  @Test ID: R33
     */
    @Test
    public void testSetName(){
       String newName="newRecipe";
       recipe.setName(newName);
       assertEquals(newName, recipe.getName());
    }

    /**
     *  @Test ID: R34
     */
    @Test
    public void testSetNameToNull(){
        recipe.setName(null);
        //assertNotNull(recipe.getName());     //  Q: is it better to assert the value or just to make sure it is not null ?
        assertEquals("Recipe1", recipe.getName());
    }

/**
            **** Test Price attribute set and get functions ****
 */

    /**
     *  @Test ID: R35
     */
    @Test
    public void testGetPrice(){
        assertEquals(50, recipe.getPrice());
    }

    /**
     *  @Test ID: R36
     */
    @Test
    public void testSetPrice() {
        try{
            recipe.setPrice("45");
            assertEquals(45, recipe.getPrice());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }
    }


    /**
     *  @Test ID: R37
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtPricePositiveInt(){
        try{
            recipe.setPrice(50+ "");
            assertEquals(50, recipe.getPrice());
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }
    }

    /**
     *  @Test ID: R38
     */
    @Test
    public void testSetAmtPriceNegativeValue(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice("-10");
                }
        );
    }

    /**
     *  @Test ID: R39
     */
    @Test
    public void testSetAmtPriceDoubleValue(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice("45.5");
                }
        );
    }

    /**
     *  @Test ID: R40
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtPriceNegativeInt(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice(-1 + "");
                }
        );
    }
    /**
     *  @Test ID: R41
     */
    @Test
    public void testSetAmtPriceToChar(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice("a");
                }
        );
    }
    /**
     *  @Test ID: R42
     */
    @Test
    public void testSetAmtPriceToEmpty(){
        exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice("");
                }
        );
    }
/**
            **** Test Recipe class functions  ****
 */

    /**
     *  @Test ID: R43
     */
    @Test
    public void testToString() {
        assertEquals(recipe.getName(), recipe.toString());
    }

    /**
     *  @Test ID: R44               Q: which alternative? Does it even matter?
     */
    @Test
    public void testToHashCode(){

        // Alternative 1
        assertTrue(recipe.equals(recipe2) && recipe2.equals(recipe));
        // Alternative 2
        assertNotSame(recipe, recipe2);
        assertEquals(recipe.hashCode(), recipe2.hashCode());

    }

    /**
     *  @Test ID: R45
     */
    @Test
    public void testEquals(){
        assertTrue(recipe.equals(recipe2));
    }

    /**
     *  @Test ID: R46
     */
    @Test
    public void testEqualsNull(){
        recipe2 = null;
        assertFalse(recipe.equals(recipe2));
    }

    /**
     *  @Test ID: R47
     */
    @Test
    public void testEqualsReturnFalse(){
        recipe2.setName("Choco");
        assertFalse(recipe.equals(recipe2));
    }

    /**
     *  @Test ID: R48
     */
    @Test
    public void testEqualsReturnTrueSameNameDiffPrice() throws RecipeException{
        recipe.setPrice("80");
        assertTrue(recipe.equals(recipe2));
    }








}
