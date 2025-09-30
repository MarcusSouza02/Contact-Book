package br.inatel.cdg.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressBookTest {
    private AddressBook addressBook;

    @Before
    public void setup() {
        addressBook = new AddressBook();
    }

    @Test
    public void testAddContact() {
        Contact c = new Contact("Maria", "12121212", "maria@email.com");
        addressBook.addContact(c);
        assertEquals(1, addressBook.listContacts().size());
    }

    @Test
    public void testAddDuplicateContact() {
        Contact c1 = new Contact("Joao", "11111", "john@email.com");
        Contact c2 = new Contact("Joao", "22222", "john2@email.com");
        addressBook.addContact(c1);

        try {
            addressBook.addContact(c2);
            fail("Expected IllegalArgumentException for duplicate contact");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testRemoveContact() {
        Contact c = new Contact("Ana", "33333", "ana@email.com");
        addressBook.addContact(c);
        addressBook.removeContact("Ana");
        assertEquals(0, addressBook.listContacts().size());
    }

    @Test
    public void testFindContact() {
        Contact c = new Contact("Peter", "44444", "peter@email.com");
        addressBook.addContact(c);
        assertNotNull(addressBook.findContact("Peter"));
    }

    @Test
    public void testFindNonExistentContact() {
        assertNull(addressBook.findContact("Carlos"));
    }

    @Test
    public void testAddMultipleContacts() {
        Contact c1 = new Contact("Alice", "55555", "alice@email.com");
        Contact c2 = new Contact("Bob", "66666", "bob@email.com");
        addressBook.addContact(c1);
        addressBook.addContact(c2);
        assertEquals(2, addressBook.listContacts().size());
    }

    @Test
    public void testAddContactsSameEmailDifferentName() {
        Contact c1 = new Contact("Kevin", "50505", "kevin@email.com");
        Contact c2 = new Contact("Leo", "60606", "kevin@email.com");
        addressBook.addContact(c1);
        addressBook.addContact(c2);
        assertEquals(2, addressBook.listContacts().size());
    }

    @Test
    public void testAddEmptyContact() {
        Contact c = new Contact("", "", "");
        addressBook.addContact(c);
        assertEquals(1, addressBook.listContacts().size());
        assertEquals("", addressBook.listContacts().get(0).getName());
    }

    @Test
    public void testAddNullValuesContact() {
        Contact c = new Contact(null, null, null);
        addressBook.addContact(c);
        assertEquals(1, addressBook.listContacts().size());
        assertNull(addressBook.listContacts().get(0).getName());
    }

    @Test
    public void testInitialListEmpty() {
        assertTrue(addressBook.listContacts().isEmpty());
    }

    @Test
    public void testAddRemoveMultipleContacts() {
        Contact c1 = new Contact("Fiona", "88888", "fiona@email.com");
        Contact c2 = new Contact("George", "99999", "george@email.com");
        addressBook.addContact(c1);
        addressBook.addContact(c2);
        addressBook.removeContact("Fiona");
        assertEquals(1, addressBook.listContacts().size());
        assertNotNull(addressBook.findContact("George"));
    }

    @Test
    public void testDuplicateDifferentPhone() {
        Contact c1 = new Contact("Hannah", "10101", "hannah@email.com");
        Contact c2 = new Contact("Hannah", "20202", "hannah2@email.com");
        addressBook.addContact(c1);

        try {
            addressBook.addContact(c2);
            fail("Expected IllegalArgumentException for duplicate name");
        } catch (IllegalArgumentException e) {
            // Test passed
        }
    }

    @Test
    public void testListContactsMultiple() {
        Contact c1 = new Contact("Anna", "11111", "anna@email.com");
        Contact c2 = new Contact("Brian", "22222", "brian@email.com");
        addressBook.addContact(c1);
        addressBook.addContact(c2);
        assertEquals(2, addressBook.listContacts().size());
        assertTrue(addressBook.listContacts().contains(c1));
        assertTrue(addressBook.listContacts().contains(c2));
    }

    @Test
    public void testAddContactWithNullValues() {
        Contact c = new Contact(null, null, null);
        addressBook.addContact(c);
        assertEquals(1, addressBook.listContacts().size());
        assertNull(addressBook.listContacts().get(0).getName());
        assertNull(addressBook.listContacts().get(0).getPhone());
        assertNull(addressBook.listContacts().get(0).getEmail());
    }

    @Test
    public void testDuplicateEmailDifferentName() {
        Contact c1 = new Contact("Kevin", "50505", "kevin@email.com");
        Contact c2 = new Contact("Leo", "60606", "kevin@email.com"); // mesmo email, nome diferente
        addressBook.addContact(c1);
        addressBook.addContact(c2);
        assertEquals(2, addressBook.listContacts().size());
    }
}
