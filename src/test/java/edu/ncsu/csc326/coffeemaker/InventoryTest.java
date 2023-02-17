package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryTest {
    private Inventory inventory;
    private Inventory testInvetory;
    private final String inventoryExceptionFailMessage = "InventoryException should not be thrown";
    private int defaultInventoryValue = 15;
    @Before
    public void setUp() {
        inventory = new Inventory();
        testInvetory = new Inventory();

    }
/**
 **** Test Chocolate attribute functions ****
 */
    /**
     *  @Test ID: I1
     */
    @Test
    public void testGetChocolate(){
        assertEquals(inventory.getChocolate(), inventory.getChocolate());
    }


    /**
     *  @Test ID: I2
     */
    @Test
    public void testSetChocolatePositiveInt(){
        inventory.setChocolate(50);
        assertEquals(50, inventory.getChocolate());
    }

    /**
     *  @Test ID: I3
     */
    @Test
    public void testSetChocolateToZero(){
        inventory.setChocolate(0);
        assertEquals(0, inventory.getChocolate());
    }

    /**
     *  @Test ID: I4
     */
    @Test
    public void testSetChocolateNegativeInt(){
        inventory.setChocolate(-100);
        assertEquals(testInvetory.getChocolate(), inventory.getChocolate());
    }

    /**
     *  @Test ID: I5
     */
    @Test
    public void testAddChocolate(){
        try{
            inventory.addChocolate("50");
        } catch(InventoryException e) {
            fail(inventoryExceptionFailMessage + "\n" + e.getMessage() );
        }

        assertEquals(testInvetory.getChocolate() + 50, inventory.getChocolate());
    }

    /**
     *  @Test ID: I6
     */
    @Test
    public void testAddChocolateNegativeValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addChocolate("-1");
                }
        );
    }

    /**
     *  @Test ID: I7
     */
    @Test
    public void testAddChocolateDoubleValue(){
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addChocolate("2.5");
                }
        );
    }

    /**
     *  @Test ID: I8
     */
    @Test
    public void testAddChocolateCharValue(){
        assertThrows(InventoryException.class, () -> {
            inventory.addChocolate("x");});
    }

    /**
     *  @Test ID: I11
     */
    @Test
    public void testAddChocolateNullValue(){
        assertThrows(InventoryException.class, () -> {
            inventory.addChocolate(null);}
        );
    }



}