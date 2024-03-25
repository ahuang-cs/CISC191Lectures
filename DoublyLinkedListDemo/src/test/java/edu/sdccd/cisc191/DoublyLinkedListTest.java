package edu.sdccd.cisc191;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void size() {
        List<Integer> dll = new DoublyLinkedList<>();
        assertEquals(0, dll.size());

        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        assertEquals(5, dll.size());

    }

    @Test
    void isEmpty() {
        List<Integer> dll = new DoublyLinkedList<>();
        assertTrue(dll.isEmpty());
        dll.add(0);
        dll.add(1);
        assertFalse(dll.isEmpty());
    }

    @Test
    void contains() {
        List<Integer> dll = new DoublyLinkedList<>();

        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        assertTrue(dll.contains(3));
        assertFalse(dll.contains(5));
    }

    @Test
    void iterator() {
        List<Integer> dll = new DoublyLinkedList<>();

        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        StringBuilder sb = new StringBuilder();
        for(Iterator<Integer> itr = dll.iterator(); itr.hasNext();) {
            Integer i = itr.next();
            sb.append(i);
            sb.append(" ");
        }

        assertEquals(sb.toString().trim(), dll.toString());
    }

    @Test
    void toArray() {
        List<Integer> dll = new DoublyLinkedList<>();

        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        StringBuilder sb = new StringBuilder();
        for(Object i: dll.toArray()) {
            sb.append(i);
            sb.append(" ");
        }

        assertEquals(sb.toString().trim(), dll.toString());
    }

    @Test
    void testToArray() {
        List<Integer> dll = new DoublyLinkedList<>();

        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        Integer[] newArr = new Integer[dll.size()];
        StringBuilder sb = new StringBuilder();
        for(Integer i: dll.toArray(newArr)) {
            sb.append(i);
            sb.append(" ");
        }

        assertEquals(sb.toString().trim(), dll.toString());
    }

    @Test
    void add() {
        List<Integer> dll = new DoublyLinkedList<>();
        assertEquals(0, dll.size());

        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        assertEquals("0 1 2 3 4", dll.toString());
    }

    @Test
    void remove() {
        List<Integer> dll = new DoublyLinkedList<>();
        assertEquals(0, dll.size());

        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        assertEquals("0 1 2 3 4", dll.toString());

        dll.remove(new Integer(2));
        dll.remove(new Integer(3));
        assertEquals("0 1 4", dll.toString());
    }

    @Test
    void containsAll() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        assertTrue(dll.containsAll(Arrays.asList(1,2,3)));
        assertFalse(dll.containsAll(Arrays.asList(1,2,3,5)));
    }

    @Test
    void addAll() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4));
        assertEquals("0 1 2 3 4", dll.toString());
    }

    @Test
    void testAddAll() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        dll.addAll(3, Arrays.asList(9,8,7,6,5));
        assertEquals("0 1 2 3 9 8 7 6 5 4", dll.toString());
    }

    @Test
    void removeAll() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4));
        assertEquals("0 1 2 3 4", dll.toString());

        dll.removeAll(Arrays.asList(2,3));
        assertEquals("0 1 4", dll.toString());
    }

    @Test
    void retainAll() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4));
        assertEquals("0 1 2 3 4", dll.toString());

        dll.retainAll(Arrays.asList(2,3));
        assertEquals("2 3", dll.toString());
    }

    @Test
    void clear() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4));
        assertEquals("0 1 2 3 4", dll.toString());
        dll.clear();
        assertEquals("", dll.toString());
    }

    @Test
    void get() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4));
        assertEquals(1, dll.get(1));
        assertEquals(null, dll.get(5));
    }

    @Test
    void set() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4));
        assertEquals(9, dll.set(1, 9));
        assertEquals(9, dll.get(1));
        assertEquals(null, dll.set(5, 10));
    }

    @Test
    void testAdd() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        assertEquals("0 1 2 3 4", dll.toString());
        dll.add(0,9);
        dll.add(2,8);
        assertEquals("0 9 1 8 2 3 4", dll.toString());
    }

    @Test
    void testRemove() {
        List<Integer> dll = new DoublyLinkedList<>();
        assertEquals(0, dll.size());

        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        assertEquals("0 1 2 3 4", dll.toString());

        assertEquals(2, dll.remove(2));
        assertEquals("0 1 3 4", dll.toString());
    }

    @Test
    void indexOf() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4));
        assertEquals(3, dll.indexOf(3));
        assertEquals(-1, dll.indexOf(5));
    }

    @Test
    void lastIndexOf() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4,5,4,3,2,1,0));
        assertEquals(9, dll.lastIndexOf(1));
        assertEquals(-1, dll.lastIndexOf(6));
    }

    @Test
    void listIterator() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4));
        ListIterator<Integer> itr = dll.listIterator();
        assertEquals(0, itr.next());
        assertEquals(1, itr.next());
        assertEquals(2, itr.next());
        assertEquals(3, itr.next());
        assertEquals(4, itr.next());
        assertEquals(null, itr.next());
        assertEquals(3, itr.previous());
        assertEquals(2, itr.previous());
        assertEquals(1, itr.previous());
        assertEquals(0, itr.previous());
        assertEquals(null, itr.previous());
    }

    @Test
    void testListIterator() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4));
        ListIterator<Integer> itr = dll.listIterator(2);
        assertEquals(2, itr.next());
        assertEquals(3, itr.next());
        assertEquals(4, itr.next());
        assertEquals(null, itr.next());
        assertEquals(3, itr.previous());
        assertEquals(2, itr.previous());
        assertEquals(1, itr.previous());
        assertEquals(0, itr.previous());
        assertEquals(null, itr.previous());
    }

    @Test
    void subList() {
        List<Integer> dll = new DoublyLinkedList<>();
        dll.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        List<Integer> subList = dll.subList(2 ,5);
        assertEquals(2, subList.get(0));
        assertEquals(3, subList.get(1));
        assertEquals(4, subList.get(2));
        assertEquals(5, subList.get(3));
        assertThrows(IndexOutOfBoundsException.class, ()->subList.get(4));

    }
}