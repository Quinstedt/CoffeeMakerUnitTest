package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecipeTest {

    private Recipe recipe;
    private Recipe recipe2;
    private final String recipeExceptionFailMessage = "RecipeException should not be thrown";


    @Before
    public void setUp() {
        try{
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

        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }

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
        assertThrows(
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
        assertThrows(
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
        assertThrows(
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
        assertThrows(
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
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtChocolate("");
                }
        );
    }
    /**
     *  @Test ID: R9
     */
    @Test
    public void testSetAmtChocolateToNull(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee(null);
                }
        );
    }

/**
            **** Test Coffee attribute set and get functions  ****
 */


    /**
     *  @Test ID: R10
     */
    @Test
    public void testGetAmtCoffee(){
        assertEquals(4, recipe.getAmtCoffee());
    }

    /**
     *  @Test ID: R11
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
     *  @Test ID: R12
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
     *  @Test ID: R13
     */
    @Test
    public void testSetAmtCoffeeNegativeValue(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("-1");
                }
        );
    }
    /**
     *  @Test ID: R14
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtCoffeeNegativeInt(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee(-1 + "");
                }
        );
    }
    /**
     *  @Test ID: R15
     */
    @Test
    public void testSetAmtCoffeeToADoubleValue(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("1.5");
                }
        );
    }

    /**
     *  @Test ID: R16
     */
    @Test
    public void testSetAmtCoffeeToChar(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("a");
                }
        );
    }
    /**
     *  @Test ID: R17
     */
    @Test
    public void testSetAmtCoffeeToEmpty(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("");
                }
        );
    }

    /**
     *  @Test ID: R18
     */
    @Test
    public void testSetAmtCoffeeToNull(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee(null);
                }
        );

    }

/**
            **** Test Milk attribute set and get functions  ****
 */

    /**
     *  @Test ID: R19
     */
    @Test
    public void testGetAmtMilk(){
        assertEquals(1, recipe.getAmtMilk());
    }

    /**
     *  @Test ID: R20
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
     *  @Test ID: R21
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
     *  @Test ID: R22
     */
    @Test
    public void testSetAmtMilkNegativeValue(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("-1");
                }
        );
    }

    /**
     *  @Test ID: R23
     */
    @Test
    public void testSetAmtMilkToADoubleValue(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("1.5");
                }
        );
    }

    /**
     *  @Test ID: R24
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtMilkNegativeInt(){
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk(-1 + "");
                }
        );
    }
    /**
     *  @Test ID: R25
     */
    @Test
    public void testSetAmtMilkToChar(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("a");
                }
        );
    }
    /**
     *  @Test ID: R26
     */
    @Test
    public void testSetAmtMilkToEmpty(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("");
                }
        );
    }

    /**
     *  @Test ID: R27
     */
    @Test
    public void testSetAmtMilkToNull(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk(null);
                }
        );

    }

/**
            **** Test Sugar attribute set and get functions  ****
 */

    /**
     *  @Test ID: R28
     */
    @Test
    public void testGetAmtSugar(){
        assertEquals(5, recipe.getAmtSugar());
    }
    /**
     *  @Test ID: R29
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
     *  @Test ID: R30
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
     *  @Test ID: R31
     */
    @Test
    public void testSetAmtSugarNegativeValue(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("-1");
                }
        );
    }

    /**
     *  @Test ID: R32
     */
    @Test
    public void testSetAmtSugarDoubleValue(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("1.5");
                }
        );
    }

    /**
     *  @Test ID: R33
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtSugarNegativeInt(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar(-1 + "");
                }
        );
    }
    /**
     *  @Test ID: R34
     */
    @Test
    public void testSetAmtSugarToChar(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("a");
                }
        );
    }
    /**
     *  @Test ID: R35
     */
    @Test
    public void testSetAmtSugarToEmpty(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("");
                }
        );
    }

    /**
     *  @Test ID: R36
     */
    @Test
    public void testSetAmtSugarToNull(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar(null);
                }
        );

    }

/**
             **** Test Name attribute ****
 */

    /**
     *  @Test ID: R37
     */
    @Test
    public void testGetName(){
        assertEquals("Recipe1", recipe.getName());
    }
    /**
     *  @Test ID: R38
     */
    @Test
    public void testSetName(){
       String newName="newRecipe";
       recipe.setName(newName);
       assertEquals(newName, recipe.getName());
    }

    /**
     *  @Test ID: R39
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
     *  @Test ID: R40
     */
    @Test
    public void testGetPrice(){
        assertEquals(50, recipe.getPrice());
    }

    /**
     *  @Test ID: R41
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
     *  @Test ID: R42
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
     *  @Test ID: R43
     */
    @Test
    public void testSetAmtPriceNegativeValue(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice("-10");
                }
        );
    }

    /**
     *  @Test ID: R44
     */
    @Test
    public void testSetAmtPriceDoubleValue(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice("45.5");
                }
        );
    }

    /**
     *  @Test ID: R45
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtPriceNegativeInt(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice(-1 + "");
                }
        );
    }
    /**
     *  @Test ID: R46
     */
    @Test
    public void testSetAmtPriceToChar(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice("a");
                }
        );
    }
    /**
     *  @Test ID: R47
     */
    @Test
    public void testSetAmtPriceToEmpty(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice("");
                }
        );
    }

    /**
     *  @Test ID: R48
     */
    @Test
    public void testSetAmtPriceToNull(){
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice(null);
                }
        );

    }
/**
            **** Test Recipe class functions  ****
 */

    /**
     *  @Test ID: R49
     */
    @Test
    public void testToString() {
        assertEquals(recipe.getName(), recipe.toString());
    }

    /**
     *  @Test ID: R50               Q: which alternative? Does it even matter?
     */
    @Test
    public void testToHashCode(){
        assertNotSame(recipe, recipe2);
        assertEquals(recipe.hashCode(), recipe2.hashCode());

    }

    /**
     *  @Test ID: R51
     */
    @Test
    public void testEquals(){
        assertTrue(recipe.equals(recipe2));
    }

    /**
     *  @Test ID: R52
     */
    @Test
    public void testEqualsReturnTrueSameNameDiffPrice(){
        try{
            recipe.setPrice("80");
        }catch (RecipeException e){
            fail(recipeExceptionFailMessage);
        }

        assertTrue(recipe.equals(recipe2));
    }

    /**
     *  @Test ID: R53           Notation: Question should this check be in the equals method or
     *      Discuss: assert true or assert false. Dependence on where the check should be for it.
     */
    @Test
    public void testEqualsCheckRecipeWithSameValueButDiffName(){
        recipe2.setName("Choco");
        assertFalse(recipe.equals(recipe2));
    }


    /**
     *  Going beyond with the equals method
     *  Try to get 100% line coverage - Result: not possible Max 97%.
     *  Name is never null - so the last two lines are never executed
     */


    /**
     *  @Test ID: R54
     */
    @Test
    public void testEqualsRecipeIsNull(){
        recipe2 = null;
        assertFalse(recipe.equals(recipe2));
    }


    /**
     *  @Test ID: R55
     */
    @Test
    public void testEqualsIfThisEqualsObj() {
        assertTrue(recipe.equals(recipe));
    }

    /**
     *  @Test ID: R56
     */
    @Test
    public void testEqualsIfObjDiffClass(){
        RecipeBook recipeBook = new RecipeBook();
        assertFalse(recipe.equals(recipeBook));
    }











}
