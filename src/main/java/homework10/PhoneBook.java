package homework10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        contacts.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> find(String name) {
        return contacts.getOrDefault(name, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Васильева Настя", "8 977 123 12 12");
        phoneBook.add("Петрова Надежда", "8 977 123 14 14");
        phoneBook.add("Петрова Надежда", "8 977 123 14 14");
        phoneBook.add("Зайцева Александра", "8 977 123 15 15");

        printPhoneNumbers(phoneBook, "Васильева Настя");
        printPhoneNumbers(phoneBook, "Петрова Надежда");
        printPhoneNumbers(phoneBook, "Зайцева Александра");
        printPhoneNumbers(phoneBook, "Киселев Андрей");
    }

    private static void printPhoneNumbers(PhoneBook phoneBook, String name) {
        List<String> phoneNumbers = phoneBook.find(name);
        if (phoneNumbers.isEmpty()) {
            System.out.println("Отсутвуют номера в справочнике по имени: " + name);
        } else {
            System.out.println("Номера в справочнике для имени " + name + ": " + phoneNumbers);
        }
    }
}