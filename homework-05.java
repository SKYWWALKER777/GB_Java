import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {

        Map<String, List<String>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Иванов", "1231234");
        addContact(phoneBook, "Иванов", "3456345");
        addContact(phoneBook, "Иванов", "5676585");
        addContact(phoneBook, "Петров", "12345");
        addContact(phoneBook, "Петров", "82332");

        printPhoneBook(phoneBook);
    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {

            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {

            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    private static void printPhoneBook(Map<String, List<String>> phoneBook) {

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ":");
            for (String phoneNumber : phoneNumbers) {
                System.out.println(phoneNumber);
            }
            System.out.println();
        }
    }
}
