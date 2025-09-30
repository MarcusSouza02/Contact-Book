package br.inatel.cdg.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testGetters() {
        Contact c = new Contact("Alice", "12345", "alice@email.com");
        assertEquals("Alice", c.getName());
        assertEquals("12345", c.getPhone());
        assertEquals("alice@email.com", c.getEmail());
    }

    @Test
    public void testToString() {
        Contact c = new Contact("Bob", "67890", "bob@email.com");
        assertEquals("Bob | 67890 | bob@email.com", c.toString());
    }

    @Test
    public void testEmptyStrings() {
        Contact c = new Contact("", "", "");
        assertEquals("", c.getName());
        assertEquals("", c.getPhone());
        assertEquals("", c.getEmail());
        assertEquals(" |  | ", c.toString());
    }

    @Test
    public void testNullValues() {
        Contact c = new Contact(null, null, null);
        assertNull(c.getName());
        assertNull(c.getPhone());
        assertNull(c.getEmail());
        assertEquals("null | null | null", c.toString());
    }

    @Test
    public void testSameContent() {
        Contact c1 = new Contact("Charlie", "11111", "charlie@email.com");
        Contact c2 = new Contact("Charlie", "11111", "charlie@email.com");
        assertNotSame(c1, c2);
        assertEquals(c1.getName(), c2.getName());
        assertEquals(c1.getPhone(), c2.getPhone());
        assertEquals(c1.getEmail(), c2.getEmail());
    }
}
