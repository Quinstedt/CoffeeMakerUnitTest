package edu.ncsu.csc326.coffeemaker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CoffeeMakerTest.class, RecipeTest.class, InventoryTest.class, RecipeBookTest.class })
public class TestSuite {
}
