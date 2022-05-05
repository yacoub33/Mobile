import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> contacts;

    public MobilePhone(String phoneNumber) {
        this.myNumber = phoneNumber;
        this.contacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact) != -1){
            return false;
        }
        return contacts.add(contact);
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        if(findContact(oldContact) != -1){
            return contacts.remove(oldContact) && contacts.add(newContact);
        } else return false;
    }

    public boolean removeContact(Contact contact){
        return findContact(contact) == -1 ? false : contacts.remove(contact);
    }

    private int findContact(Contact queryContact) {
        return findContact(queryContact.getName());
    }

    private int findContact(String contactName) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(contactName)) {
                return contact;
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println(i+1 + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
