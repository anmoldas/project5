package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Before;

/**
 * Tests LinkedList
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * @version 2017.04.19
 *
 */

public class LinkedListTest extends student.TestCase {

    private LinkedList<String> list;
    private Iterator<String> iterator;


    /**
     * Sets up the test class
     */
    @Before
    public void setUp() {
        list = new LinkedList<String>();
    }


    /**
     * Tests add method
     */
    public void testAdd() {
        assertTrue(list.isEmpty());
        list.add("anmol");
        assertEquals(list.size(), 1);
        assertFalse(list.isEmpty());
    }


    /**
     * Tests add method when index < 0
     */
    public void testAddException() {

        Exception exception = null;
        try {
            list.add(-1, "anmol");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests add method when index > size
     */
    public void testAddException2() {

        Exception exception = null;
        try {
            list.add(6, "anmol");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests add method
     */

    public void testAddException3() {

        Exception exception = null;
        try {
            list.add(0, null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * Tests add method
     */
    public void testAdd2() {
        list.add("anmol");
        list.add("harsha");
        list.add(0, "tarun");
        assertEquals(list.size(), 3);
    }


    /**
     * Tests setData method
     */
    public void testSetData() {
        list.add("tarun");
        list.set(0, "harsha");
        assertEquals(list.get(0), "harsha");
        list.getNodeAtIndex(0).setData("tarun");
        assertEquals(list.get(0), "tarun");
    }


    /**
     * Tests add method
     */
    public void testAdd3() {
        list.add("anmol");
        list.add("harsha");
        list.add(1, "tarun");
        assertEquals(list.size(), 3);
    }


    /**
     * Tests get method when index < 0
     */
    public void testGetException() {

        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests get method when index > size
     */
    public void testGetException2() {
        list.add("anmol");
        list.add("harsha");

        Exception exception = null;
        try {
            list.get(5);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests get method
     */
    public void testGet() {
        list.add("anmol");
        list.add("harsha");
        list.add("tarun");

        assertEquals(list.get(1), "harsha");
    }


    /**
     * Tests contains method
     */
    public void testContains() {
        list.add("anmol");
        list.add("harsha");
        list.add("tarun");

        assertTrue(list.contains("anmol"));
        assertFalse(list.contains("hello"));
    }


    /**
     * Tests get method when index < 0
     */
    public void testRemoveException() {

        Exception exception = null;
        try {
            list.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests get method when index > size
     */
    public void testRemoveException2() {
        list.add("anmol");
        list.add("harsha");

        Exception exception = null;
        try {
            list.remove(5);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests remove method when index = 0
     */
    public void testRemove() {
        list.add("anmol");
        list.add("harsha");
        list.add("tarun");

        list.remove(0);

        assertEquals(list.size(), 2);

    }


    /**
     * Tests remove method when index = 0
     */
    public void testRemove2() {
        list.add("anmol");
        list.remove(0);

        assertEquals(list.size(), 0);

    }


    /**
     * Tests remove method when index = size - 1
     */
    public void testRemove3() {
        list.add("anmol");
        list.add("harsha");
        list.add("tarun");

        list.remove(2);

        assertEquals(list.size(), 2);

    }


    /**
     * Tests remove method
     */
    public void testRemove4() {
        list.add("anmol");
        list.add("harsha");
        list.add("tarun");

        list.remove(1);

        assertEquals(list.size(), 2);

    }


    /**
     * Tests remove method
     */
    public void testRemove5() {
        list.add("anmol");
        list.add("harsha");
        list.remove("anmol");
        assertEquals(list.size(), 1);
    }


    /**
     * Tests remove method
     */
    public void testRemove6() {
        list.add("anmol");
        list.remove("harsha");
        assertEquals(list.size(), 1);
    }


    /**
     * Tests remove method
     */
    public void testRemove7() {
        list.add("anmol");
        list.add("harsha");
        list.remove("harsha");
        assertEquals(list.size(), 1);
    }


    /**
     * Tests clear method
     */

    public void testClear() {
        list.add("anmol");
        list.clear();
        assertTrue(list.isEmpty());

    }


    /**
     * tests the hasNext method
     */
    public void testHasNext() {
        iterator = list.iterator();
        assertFalse(iterator.hasNext());
        list.add("anmol");
        assertTrue(iterator.hasNext());
    }


    /**
     * tests the next method when there is no elements
     */
    public void testNext() {
        iterator = list.iterator();

        Exception exception = null;
        try {
            iterator.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof NoSuchElementException);

    }


    /**
     * tests the next method when there is no elements
     */
    public void testNext2() {
        iterator = list.iterator();
        list.add("danya");
        list.add("danya2.0");
        assertEquals(iterator.next(), "danya");

    }

/*    *//**
         * tests next method when there is a next element
         *//*
           * public void testNext2() {
           * iterator = list.iterator();
           * 
           * list.add("anmol");
           * list.add("harsha");
           * list.add("tarun");
           * assertEquals(iterator.next(), "anmol");
           * 
           * }
           */


    /**
     * tests remove
     */
    public void testIteratorRemove() {
        iterator = list.iterator();
        Exception exception = null;
        try {
            iterator.remove();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
    }


    /**
     * tests remove
     */

    public void testIteratorRemove2() {
        list.add("red");

        Iterator<String> iterate = list.iterator();

        Exception thrown = null;
        try {
            iterate.remove();
        }
        catch (IllegalStateException e) {
            thrown = e;
        }
        assertNotNull(thrown);

        iterate.next();
        iterate.remove();

        thrown = null;
        try {
            iterate.remove();
        }
        catch (IllegalStateException e) {
            thrown = e;
        }
    }

}
