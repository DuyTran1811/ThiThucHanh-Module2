package QuanLyDanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Manager {
    String empFileName = "File.DAT";
    List<Contact> listContact = new ArrayList(readEmpFromFile(empFileName));

    public static void display(List<Contact> contacts) {
        out.printf("%-15s%-20s%-15s%-20s%-15s%-15s%-15s\n", "PhonNumber", "Group", "name", "gio tinh", "address", "dateOfBirth", "email");
        for (Contact cont : contacts) {
            show(cont);
        }
    }

    public static void show(Contact cont) {
        out.printf("%-15s%-20s%-15s%-20s%-15s\n",cont.getPhoneNumber(), cont.getGroup(), cont.getName(), cont.getGiotinh(), cont.getEmail());

    }

    public static boolean removeEmp(List<Contact> cont, String id) {
        for (int i = 0; i < cont.size(); i++) {
            if (cont.get(i).getName().compareTo(id) == 0) {
                cont.remove(i);
                return true;
            }
        }
        return false;
    }


    public static List<Contact> readEmpFromFile(String fileName) {
        List<Contact> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object mObj = ois.readObject();
            if (mObj != null) {
                employees = (ArrayList<Contact>) mObj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
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

    public static Contact searchAnEmpById(List<Contact> employees, String id) {
        for (Contact employee : employees) {
            if (employee.getName().compareToIgnoreCase(id) == 0) {
                return employee;
            }
        }
        return null;
    }
    public static List<Contact> SearchID(List<Contact> cot,String id){
        List<Contact> result = new ArrayList<>();
        for (Contact cont:cot) {
            if (cont.getName().toLowerCase().matches(".*"+id.toLowerCase()+".*")){
                result.add(cont);
            }
        }
        return result;
    }

}
