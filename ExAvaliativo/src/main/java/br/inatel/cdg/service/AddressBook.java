package br.inatel.cdg.service;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(contact.getName())) {
                throw new IllegalArgumentException("Contact already exists: " + contact.getName());
            }
        }
        contacts.add(contact);
    }

    public void removeContact(String name) {
        Contact found = findContact(name);
        if (found == null) {
            throw new IllegalArgumentException("Contact not found: " + name);
        }
        contacts.remove(found);
    }

    public Contact findContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public List<Contact> listContacts() {
        return contacts;
    }
}
