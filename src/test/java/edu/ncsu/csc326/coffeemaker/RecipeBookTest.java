package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeBookTest {

    private Recipe recipe;
    private RecipeBook recipeBook;
    private Recipe[] recipesTestArray;
    private final String recipeExceptionFailMessage = "RecipeException should not be thrown";

    @Before
    public void setUp(){
        int MAX_NR_OF_RECIPES = 4;
        recipeBook = new RecipeBook();
        recipesTestArray = new Recipe[MAX_NR_OF_RECIPES];
        try {
            recipe = new Recipe();
            recipe.setName("Choco");
            recipe.setAmtChocolate("2");
            recipe.setAmtCoffee("0");
            recipe.setAmtMilk("1");
            recipe.setAmtSugar("5");
            recipe.setPrice("50");
        } catch (RecipeException e){
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
    }

    /**
     *  @Test ID: RB1
     */
    @Test
    public void testGetRecipes() {
        assertArrayEquals(recipesTestArray, recipeBook.getRecipes());
    }

    /**
     *  @Test ID: RB2
     */
    @Test
    public void testAddRecipe() {
        assertTrue(recipeBook.addRecipe(recipe));
        recipesTestArray[0] = recipe;
        assertArrayEquals(recipesTestArray, recipeBook.getRecipes());
    }

    /**
     *  @Test ID: RB3
     */
    @Test
    public void testSameRecipeWithDiffNameAndSameIngredient() {
        Recipe recipe2 = new Recipe();
        try {
            recipe2.setName("Choco2");
            recipe2.setAmtChocolate("2");
            recipe2.setAmtCoffee("0");
            recipe2.setAmtMilk("1");
            recipe2.setAmtSugar("5");
            recipe2.setPrice("50");
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
        recipeBook.addRecipe(recipe);
        recipeBook.addRecipe(recipe2);
        assertFalse(recipeBook.addRecipe(recipe2));
        recipesTestArray[0] = recipe;
        assertArrayEquals(recipesTestArray, recipeBook.getRecipes());
    }

    /**
     *  @Test ID: RB4
     */
    @Test
    public void testAddRecipeThatAlreadyExist(){
        recipeBook.addRecipe(recipe);
        recipesTestArray[0] = recipe;
        assertFalse(recipeBook.addRecipe(recipe));
        assertArrayEquals(recipesTestArray, recipeBook.getRecipes());
    }

    /**
     *  @Test ID: RB5
     */
    @Test
    public void testAddRecipeInFullRecipeBook() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        Recipe recipe3 = new Recipe();
        Recipe recipe4 = new Recipe();
        try {
            recipe1.setName("recipe1");
            recipe1.setAmtChocolate("1");
            recipe2.setName("recipe2");
            recipe1.setAmtChocolate("3");
            recipe3.setName("recipe3");
            recipe1.setAmtChocolate("4");
            recipe4.setName("recipe4");
            recipe1.setAmtChocolate("5");
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
        recipeBook.addRecipe(recipe1);
        recipeBook.addRecipe(recipe2);
        recipeBook.addRecipe(recipe3);
        recipeBook.addRecipe(recipe4);
        assertFalse(recipeBook.addRecipe(recipe));
    }

    /**
     *  @Test ID: RB6
     */
    @Test
    public void testAddRecipeWithNullValue() {
        recipe = null;
        assertFalse(recipeBook.addRecipe(recipe));
    }

    /**
     *  @Test ID: RB7
     */
    @Test
    public void testDeleteRecipe() {
        recipeBook.addRecipe(recipe);
        // check that the return message is the correct one
        assertEquals(recipe.getName(), recipeBook.deleteRecipe(0));
        // check that the recipe is not the same as before
        assertNotSame(recipe, recipeBook.getRecipes()[0]);
        // check that recipe is actually null after deletion
        assertNull(recipeBook.getRecipes()[0]);
    }

    /**
     *  @Test ID: RB8
     */
    @Test
    public void testDeleteRecipeThatIsNull() {
        assertNull(recipeBook.deleteRecipe(3));
    }

    /**
     *  @Test ID: RB9
     */
    @Test
    public void testDeleteRecipeOutOfBounds() {
        assertNull(recipeBook.deleteRecipe(
                recipeBook.getRecipes().length +2
        ));
    }

    /**
     *  @Test ID: RB10
     */
    @Test
    public void testEditRecipe() {
        recipeBook.addRecipe(recipe);
        Recipe recipe1 = new Recipe();
        Recipe sameAsRecipe1 = new Recipe();
        try {
            sameAsRecipe1.setName("Coffee");
            sameAsRecipe1.setAmtChocolate("0");
            sameAsRecipe1.setAmtCoffee("3");
            sameAsRecipe1.setAmtMilk("0");
            sameAsRecipe1.setAmtSugar("1");
            sameAsRecipe1.setPrice("50");

            recipe1.setName("Coffee");
            recipe1.setAmtChocolate("0");
            recipe1.setAmtCoffee("3");
            recipe1.setAmtMilk("0");
            recipe1.setAmtSugar("1");
            recipe1.setPrice("50");
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
        recipesTestArray[0] = sameAsRecipe1;
        // Check that the correct recipe was edited
        assertEquals(recipe.getName(),recipeBook.editRecipe(0,recipe1));
        // Check that recipe was edited correctly.
        assertArrayEquals(recipesTestArray, recipeBook.getRecipes());
    }

    /**
     *  @Test ID: RB11
     */
    @Test
    public void testEditRecipeThatIsNull() {
        Recipe newRecipe = new Recipe();
        try {
            newRecipe.setName("Coffee");
            newRecipe.setAmtChocolate("0");
            newRecipe.setAmtCoffee("3");
            newRecipe.setAmtMilk("0");
            newRecipe.setAmtSugar("1");
            newRecipe.setPrice("50");
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
        assertNull(recipeBook.editRecipe(0, newRecipe));
    }

    /**
     *  @Test ID: RB12
     */
    @Test
    public void testEditRecipeWithNullRecipe() {
        recipeBook.addRecipe(recipe);
        assertNull(recipeBook.editRecipe(0, null));
    }

    /**
     *  @Test ID: RB12
     */
    @Test
    public void testEditRecipeOutOfBound() {
        recipeBook.addRecipe(recipe);
        Recipe newRecipe = new Recipe();
        try {
            newRecipe.setName("Coffee");
            newRecipe.setAmtChocolate("0");
            newRecipe.setAmtCoffee("3");
            newRecipe.setAmtMilk("0");
            newRecipe.setAmtSugar("1");
            newRecipe.setPrice("50");
        } catch (RecipeException e){
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
        assertNull(recipeBook.editRecipe(recipeBook.getRecipes().length + 2 , newRecipe));
    }

    /**
     *  @Test ID: RB13
     */
    @Test
    public void testEditRecipeToEqualAnExistingRecipe() {
        Recipe recipe2 = new Recipe();
        Recipe newRecipe = new Recipe();
        try {
            recipe2.setName("Coffee2");
            recipe2.setAmtChocolate("10");
            recipe2.setAmtCoffee("5");
            recipe2.setAmtMilk("5");
            recipe2.setAmtSugar("1");
            recipe2.setPrice("20");

            newRecipe.setName("Choco");
            newRecipe.setAmtChocolate("2");
            newRecipe.setAmtCoffee("0");
            newRecipe.setAmtMilk("1");
            newRecipe.setAmtSugar("5");
            newRecipe.setPrice("50");
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
        recipeBook.addRecipe(recipe);
        recipeBook.addRecipe(recipe2);
        recipeBook.editRecipe(1,newRecipe);

        assertNotEquals(recipeBook.getRecipes()[0], recipeBook.getRecipes()[1]);
        assertEquals(recipe2, recipeBook.getRecipes()[1]);
    }

    /**
     *  @Test ID: RB14
     */
    @Test
    public void testEditRecipeToEqualAnExistingRecipeWithDiffName() {
        Recipe recipe2 = new Recipe();
        Recipe newRecipe = new Recipe();
        try {
            recipe2.setName("Coffee2");
            recipe2.setAmtChocolate("10");
            recipe2.setAmtCoffee("5");
            recipe2.setAmtMilk("5");
            recipe2.setAmtSugar("1");
            recipe2.setPrice("20");

            newRecipe.setName("recipe1Copy");
            newRecipe.setAmtChocolate("2");
            newRecipe.setAmtCoffee("0");
            newRecipe.setAmtMilk("1");
            newRecipe.setAmtSugar("5");
            newRecipe.setPrice("5");
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
        recipeBook.addRecipe(recipe);
        recipeBook.addRecipe(recipe2);
        recipeBook.editRecipe(1,newRecipe);

        assertEquals(recipe2, recipeBook.getRecipes()[1]);
    }

    /**
     *  @Test ID: RB15
     */
    @Test
    public void testEditRecipeToEqualAnotherRecipeWithDiffPrice() {
        Recipe recipe2 = new Recipe();
        Recipe newRecipe = new Recipe();
        try {
            recipe2.setName("Coffee2");
            recipe2.setAmtChocolate("10");
            recipe2.setAmtCoffee("5");
            recipe2.setAmtMilk("5");
            recipe2.setAmtSugar("1");
            recipe2.setPrice("20");

            newRecipe.setName("recipe1Copy");
            newRecipe.setAmtChocolate("2");
            newRecipe.setAmtCoffee("0");
            newRecipe.setAmtMilk("1");
            newRecipe.setAmtSugar("5");
            newRecipe.setPrice("1000");
        } catch(RecipeException e) {
            fail(recipeExceptionFailMessage + "\n" + e.getMessage());
        }
        recipeBook.addRecipe(recipe);
        recipeBook.addRecipe(recipe2);
        recipeBook.editRecipe(1,newRecipe);

        assertEquals(recipe2, recipeBook.getRecipes()[1]);
    }

    /**
     *  @Test ID: RB16
     */
    @Test
    public void testAddRecipeWithDefaultValues() {
        Recipe defaultRecipe = new Recipe();
        assertFalse(recipeBook.addRecipe(defaultRecipe));
    }
}