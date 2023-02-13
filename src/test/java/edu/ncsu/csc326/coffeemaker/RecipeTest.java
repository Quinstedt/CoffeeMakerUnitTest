package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {

    private Recipe recipe;
    Throwable exception;


    @Before
    public void setUp() throws Exception {
        recipe = new Recipe();
        recipe.setName("Recipe1");
        recipe.setAmtChocolate("2");
        recipe.setAmtCoffee("4");
        recipe.setAmtMilk("1");
        recipe.setAmtSugar("5");
        recipe.setPrice("50");

    }

/**
            **** Test Chocolate attribute ****
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
            fail(e.getMessage()); // Question should I use fail() like this?
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
            fail(e.getMessage());
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
     *  @Test ID: R6
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
     *  @Test ID: R7
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
            **** Test Coffee attribute ****
 */


    /**
     *  @Test ID: R8
     */
    @Test
    public void testGetAmtCoffee(){
        assertEquals(4, recipe.getAmtCoffee());
    }
    /**
     *  @Test ID: R9
     */
    @Test
    public void testSetAmtCoffee(){
        try{
            recipe.setAmtCoffee("2");
            assertEquals(2, recipe.getAmtCoffee());
        }catch (RecipeException e){
            fail(e.getMessage());
        }
    }

    /**
     *  @Test ID: R10
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtCoffeePositiveInt(){
        try{
            recipe.setAmtCoffee(4 + "");
            assertEquals(4, recipe.getAmtCoffee());
        }catch (RecipeException e){
            fail(e.getMessage());
        }
    }

    /**
     *  @Test ID: R11
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
     *  @Test ID: R12
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
     *  @Test ID: R13
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
     *  @Test ID: R14
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
            **** Test Milk attribute ****
 */

    /**
     *  @Test ID: R15
     */
    @Test
    public void testGetAmtMilk(){
        assertEquals(1, recipe.getAmtMilk());
    }
    /**
     *  @Test ID: R16
     */
    @Test
    public void testSetAmtMilk(){
        try{
            recipe.setAmtMilk("1");
            assertEquals(1, recipe.getAmtMilk());
        }catch (RecipeException e){
            fail(e.getMessage());
        }
    }

    /**
     *  @Test ID: R17
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtMilkPositiveInt(){
        try{
            recipe.setAmtMilk(2 + "");
            assertEquals(2, recipe.getAmtMilk());
        }catch (RecipeException e){
            fail(e.getMessage());
        }
    }

    /**
     *  @Test ID: R18
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
     *  @Test ID: R19
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
     *  @Test ID: R20
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
     *  @Test ID: R21
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
            **** Test Sugar attribute ****
 */

    /**
     *  @Test ID: R22
     */
    @Test
    public void testGetAmtSugar(){
        assertEquals(5, recipe.getAmtSugar());
    }
    /**
     *  @Test ID: R23
     */
    @Test
    public void testSetAmtSugar(){
        try{
            recipe.setAmtSugar("1");
            assertEquals(1, recipe.getAmtSugar());
        }catch (RecipeException e){
            fail(e.getMessage()); // Question should I use fail() like this?
        }
    }

    /**
     *  @Test ID: R24
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtSugarPositiveInt(){
        try{
            recipe.setAmtSugar(2 + "");
            assertEquals(2, recipe.getAmtSugar());
        }catch (RecipeException e){
            fail(e.getMessage());
        }
    }

    /**
     *  @Test ID: R25
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
     *  @Test ID: R26
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
     *  @Test ID: R27
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
     *  @Test ID: R28
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
     *  @Test ID: R22
     */
    @Test
    public void testGetName(){
        assertEquals("Recipe1", recipe.getName());
    }
    /**
     *  @Test ID: R23
     */
    @Test
    public void testSetName(){
       String newName="newRecipe";
       recipe.setName(newName);
       assertEquals(newName, recipe.getName());
    }

    /**
     *  @Test ID: R24
     */
    @Test
    public void testSetNameToNull(){
        recipe.setName(null);
        //assertNotNull(recipe.getName());     //  Q: is it better to assert the value or just to make sure it is not null ?
        assertEquals("Recipe1", recipe.getName());
    }

}
