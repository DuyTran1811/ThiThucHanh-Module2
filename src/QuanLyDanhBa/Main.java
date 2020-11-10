package QuanLyDanhBa;

import QuanLyDanhBa.Exception.NumberException;

import static java.lang.System.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NumberException {
        int choice;
        InputInformation information = new InputInformation();
        Manager manager = new Manager();
        Scanner scan = new Scanner(System.in);
        do {
            out.println("=/=/=/=/=/=/=/MenuLis=/=/=/=/=/=");
            out.println(" ");
            out.println("1: Thêm Danh Bạn");
            out.println("2: Hiển Thị Thông Tin");
            out.println("3: Xoá Danh Bạ");
            out.println("4: Sửa Thông Tin");
            out.println("9: Saver File");
            out.println("0: Để Thoát");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    Contact contact = information.inputContact();
                    manager.listContact.add(contact);
                    break;
                case 2:
                    Manager.display(manager.listContact);
                    break;
                case 3:
                    if (manager.listContact.size() > 0) {
                        out.println("Nhap Ten: ");
                        String id = scan.nextLine();
                        boolean isDeleted = Manager.removeEmp(manager.listContact, id);
                        if (isDeleted) {
                            out.println("Deleted successfully");
                        } else {
                            out.println("Employee code incorrect");
                        }
                    } else {
                        out.println("The list of employees is empty");
                    }
                    break;
                case 4:
                    if (manager.listContact.size() > 0) {
                        out.println("Enter Name");
                        String id = scan.nextLine().trim();
                        Contact checks = Manager.searchAnEmpById(manager.listContact, id);
                        if (checks == null) {
                            out.println("Ten Khong Ton Tai: \"" + id + "\"");
                        } else {
                            out.println("Nhap Ten Moi Moi");
                            String newId = scan.nextLine();
                            checks.setName(newId);
                            out.println("Nhap Dia chi Moi");
                            String address = scan.nextLine();
                            checks.setAddress(address);
                            out.println("Nhap Ngay Sinh Moi");
                            String dateOfBirth = scan.nextLine();
                            checks.setDateOfBirth(dateOfBirth);
                        }
                    }
                    break;
                case 9:
                    if (manager.listContact.size() > 0) {
                        boolean isSuccess = Manager.writeEmpToFile(manager.listContact, manager.empFileName);
                        if (isSuccess) {
                            out.println("File recording is successful !");
                        } else {
                            out.println("File write failed!");
                        }
                    } else {
                        out.println("The list of employees is empty. File write failed");
                    }

            }
        } while (choice != 0);
    }
}
