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
        try {
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
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage);
        }
    }

/**
 *      **** Test Chocolate attribute functions ****
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
    public void testSetAmtChocolate() {
        try {
            recipe.setAmtChocolate("1");
            assertEquals(1, recipe.getAmtChocolate());
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage);
        }
    }

    /**
     *  @Test ID: R3
     */
    @Test
    public void testSetAmtChocolatePositiveInt() {
        try {
            recipe.setAmtChocolate(2 + "");
            assertEquals(2, recipe.getAmtChocolate());
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage + "\n" + e.getMessage() );
        }
    }

    /**
     *  @Test ID: R4
     */
    @Test
    public void testSetAmtChocolateNegativeValue() {
        assertThrows(
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
    public void testSetAmtChocolateNegativeInt() {
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtChocolate(-1 + "");
                }
        );
    }

    /**
     *  @Test ID: R6
     */
    @Test
    public void testSetAmtChocolateInvalidStringInput() {
        assertThrows(RecipeException.class, () -> { recipe.setAmtChocolate(""); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtCoffee(null); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtChocolate("a"); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtChocolate("1.5"); });
    }

/**
        **** Test Coffee attribute functions  ****
 */

    /**
     *  @Test ID: R7
     */
    @Test
    public void testGetAmtCoffee(){
        assertEquals(4, recipe.getAmtCoffee());
    }

    /**
     *  @Test ID: R8
     */
    @Test
    public void testSetAmtCoffee() {
        try {
            recipe.setAmtCoffee("2");
            assertEquals(2, recipe.getAmtCoffee());
        } catch(RecipeException e){
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
    }

    /**
     *  @Test ID: 9
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtCoffeePositiveInt() {
        try {
            recipe.setAmtCoffee(4 + "");
            assertEquals(4, recipe.getAmtCoffee());
        } catch(RecipeException e){
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
    }

    /**
     *  @Test ID: R10
     */
    @Test
    public void testSetAmtCoffeeNegativeValue() {
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("-1");
                }
        );
    }
    /**
     *  @Test ID: R11
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtCoffeeNegativeInt() {
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee(-1 + "");
                }
        );
    }


    /**
     *  @Test ID: R12
     */
    @Test
    public void testSetAmtCoffeeInvalidStringInput() {
        assertThrows(RecipeException.class, () -> { recipe.setAmtCoffee(""); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtCoffee(null); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtCoffee("a"); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtCoffee("1.5"); });
    }

/**
        **** Test Milk attribute functions  ****
 */

    /**
     *  @Test ID: R13
     */
    @Test
    public void testGetAmtMilk(){
        assertEquals(1, recipe.getAmtMilk());
    }

    /**
     *  @Test ID: R14
     */
    @Test
    public void testSetAmtMilk() {
        try {
            recipe.setAmtMilk("1");
            assertEquals(1, recipe.getAmtMilk());
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage+ "\n" + e.getMessage());
        }
    }

    /**
     *  @Test ID: R15
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtMilkPositiveInt() {
        try {
            recipe.setAmtMilk(2 + "");
            assertEquals(2, recipe.getAmtMilk());
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage+ "\n" + e.getMessage() );
        }
    }

    /**
     *  @Test ID: R16
     */
    @Test
    public void testSetAmtMilkNegativeValue() {
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("-1");
                }
        );
    }

    /**
     *  @Test ID: R17
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtMilkNegativeInt() {
        assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk(-1 + "");
                }
        );
    }

    /**
     *  @Test ID: R18
     */
    @Test
    public void testSetAmtMilkToInvalidStringInput() {
        assertThrows(RecipeException.class, () -> { recipe.setAmtMilk(""); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtMilk(null); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtMilk("a"); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtMilk("1.5"); });
    }

/**
        **** Test Sugar attribute functions  ****
 */

    /**
     *  @Test ID: R19
     */
    @Test
    public void testGetAmtSugar(){
        assertEquals(5, recipe.getAmtSugar());
    }

    /**
     *  @Test ID: R20
     */
    @Test
    public void testSetAmtSugar() {
        try {
            recipe.setAmtSugar("1");
            assertEquals(1, recipe.getAmtSugar());
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage+ "\n" + e.getMessage() ); // Question should I use fail() like this?
        }
    }

    /**
     *  @Test ID: R21
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtSugarPositiveInt() {
        try {
            recipe.setAmtSugar(2 + "");
            assertEquals(2, recipe.getAmtSugar());
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage+ "\n" + e.getMessage());
        }
    }

    /**
     *  @Test ID: R22
     */
    @Test
    public void testSetAmtSugarNegativeValue() {
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("-1");
                }
        );
    }


    /**
     *  @Test ID: R23
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtSugarNegativeInt() {
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar(-1 + "");
                }
        );
    }

    /**
     *  @Test ID: R24
     */
    @Test
    public void testSetAmtSugarToInvalidStringInput() {
        assertThrows(RecipeException.class, () -> { recipe.setAmtSugar(""); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtSugar(null); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtSugar("a"); });
        assertThrows(RecipeException.class, () -> { recipe.setAmtSugar("1.5"); });
    }

/**
        **** Test Name attribute functions ****
 */

    /**
     *  @Test ID: R25
     */
    @Test
    public void testGetName(){
        assertEquals("Recipe1", recipe.getName());
    }

    /**
     *  @Test ID: R26
     */
    @Test
    public void testSetName() {
       String newName = "newRecipe";
       recipe.setName(newName);
       assertEquals(newName, recipe.getName());
    }

    /**
     *  @Test ID: R27
     */
    @Test
    public void testSetNameToNull(){
        recipe.setName(null);
        assertEquals("Recipe1", recipe.getName());
    }

/**
        **** Test Price attribute functions ****
 */

    /**
     *  @Test ID: R28
     */
    @Test
    public void testGetPrice(){
        assertEquals(50, recipe.getPrice());
    }

    /**
     *  @Test ID: R29
     */
    @Test
    public void testSetPrice() {
        try {
            recipe.setPrice("45");
            assertEquals(45, recipe.getPrice());
        } catch(RecipeException e){
            fail(recipeExceptionFailMessage+ "\n" + e.getMessage());
        }
    }

    /**
     *  @Test ID: R30
     */
    @Test
    public void testSetAmtPricePositiveInt() {
        try {
            recipe.setPrice(50 + "");
            assertEquals(50, recipe.getPrice());
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage+ "\n" + e.getMessage() );
        }
    }

    /**
     *  @Test ID: R31
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
     *  @Test ID: R32
     *  Testing this format due the use of parseINT
     */
    @Test
    public void testSetAmtPriceNegativeInt() {
         assertThrows(
                RecipeException.class, () -> {
                    recipe.setPrice(-1 + "");
                }
        );
    }

    /**
     *  @Test ID: R33
     */
    @Test
    public void testSetAmtPriceToInvalidStringInput() {
        assertThrows(RecipeException.class, () -> { recipe.setPrice(""); });
        assertThrows(RecipeException.class, () -> { recipe.setPrice(null); });
        assertThrows(RecipeException.class, () -> { recipe.setPrice("a"); });
        assertThrows(RecipeException.class, () -> { recipe.setPrice("1.5"); });
    }
/**
        **** Test Recipe class functions ****
 */

    /**
     *  @Test ID: R34
     */
    @Test
    public void testToString() {
        assertEquals(recipe.getName(), recipe.toString());
    }

    /**
     *  @Test ID: R35
     */
    @Test
    public void testToHashCode() {
        assertNotSame(recipe, recipe2);
        assertEquals(recipe.hashCode(), recipe2.hashCode());
    }

    /**
     *  @Test ID: R36
     */
    @Test
    public void testEquals(){
        assertTrue(recipe.equals(recipe2));
    }

    /**
     *  @Test ID: R37
     */
    @Test
    public void testEqualsSameNameDiffPrice() {
        try {
            recipe.setPrice("80");
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage+ "\n" + e.getMessage());
        }
        assertNotEquals(recipe,recipe2);
    }

    /**
     *  @Test ID: R38
     */
    @Test
    public void testEqualsCheckRecipeWithSameValueButDiffName() {
        recipe2.setName("Choco");
        assertTrue(recipe.equals(recipe2));
    }

    /**
     *  @Test ID: R39
     */
    @Test
    public void testEqualsRecipeIsNull() {
        recipe2 = null;
        assertFalse(recipe.equals(recipe2));
    }

    /**
     *  @Test ID: R40
     */
    @Test
    public void testEqualWithSameObj() {
        assertTrue(recipe.equals(recipe));
    }

    /**
     *  @Test ID: R41
     */
    @Test
    public void testEqualsIfObjFromDiffClass() {
        RecipeBook recipeBook = new RecipeBook();
        assertFalse(recipe.equals(recipeBook));
    }














}
