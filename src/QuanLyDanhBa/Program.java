package QuanLyDanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Program {
    String empFileName = "File.CSV";
    List<Contact> listContact = new ArrayList(readFromFile(empFileName));

    public static void display(List<Contact> contacts) {
        out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "PhoneNumber", "Group", "Name", "Age", "Email", "Address", "Nam Sinh");
        for (Contact cont : contacts) {
            show(cont);
        }
    }

    public static void show(Contact cont) {
        out.printf("%-15s%-14s%-14s%-14s%-18s%-15s%-20s\n",
                cont.getPhoneNumber(), cont.getGroup(),
                cont.getName(), cont.getGiotinh(),
                cont.getEmail(),cont.getAddress(), cont.getDateOfBirth());

    }

    public static boolean remove(List<Contact> cont, String id) {
        for (int i = 0; i < cont.size(); i++) {
            if (cont.get(i).getName().compareTo(id) == 0) {
                cont.remove(i);
                return true;
            }
        }
        return false;
    }


    public static List<Contact> readFromFile(String fileName) {
        List<Contact> contacts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object mObj = ois.readObject();
            if (mObj != null) {
                contacts = (ArrayList<Contact>) mObj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public static boolean writeEmpToFile(List<Contact> cont, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(cont);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Contact searchById(List<Contact> contacts, String id) {
        for (Contact contact : contacts) {
            if (contact.getName().compareToIgnoreCase(id) == 0) {
                return contact;
            }
        }
        return null;
    }

    public static List<Contact> SearchID(List<Contact> cot, String id) {
        List<Contact> result = new ArrayList<>();
        for (Contact cont : cot) {
            if (cont.getName().toLowerCase().matches(".*" + id.toLowerCase() + ".*")) {
                result.add(cont);
            }
        }
        return result;
    }

}
