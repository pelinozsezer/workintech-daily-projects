package org.example.mobile;

import java.util.ArrayList;
import java.util.List;


public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact>  getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
            if (findContact(contact.getName()) == -1) {myContacts.add(contact); return true;}
            else {return false;}
    }



//    public boolean updateContact(Contact oldContact, Contact newContact) {
//        if (findContact(oldContact.getName()) != -1) {myContacts.remove(oldContact);myContacts.add(newContact); return true;}
//        else {return false;}
//
//    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact.getName());
        if (index != -1) {
            myContacts.set(index, newContact); // replaces at same position
            return true;
        }
        return false;
    }


    public boolean removeContact(Contact contact) {
        if (findContact(contact) != -1) {myContacts.remove(contact); return true;}
        else {return false;}

    }




    public int findContact(String contactName) {
        for (Contact item: myContacts) {
            if (item.getName().equals(contactName)) {return myContacts.indexOf(item);}
        }
        return -1;
    }


    public int findContact(Contact contact) {
        for (Contact item: myContacts) {
            if (item.getName().equals(contact.getName())) {return myContacts.indexOf(item);}
        }
        return -1;
    }







    public Contact queryContact(String name) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null; // not found
    }

    public void printContact() {
        for (Contact item: myContacts) {
            System.out.println(String.format("%s -> %s",item.getName(),item.getPhoneNumber()) ); //?
        }
    }
}
