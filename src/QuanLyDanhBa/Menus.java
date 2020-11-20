package QuanLyDanhBa;

import QuanLyDanhBa.Exception.NumberException;

import static java.lang.System.*;

import java.util.List;
import java.util.Scanner;

public class Menus {
    public static void main(String[] args) throws NumberException {
        int choice;
        InputInformation information = new InputInformation();
        Program program = new Program();
        Scanner scan = new Scanner(System.in);
        do {
            out.println();
            out.println("=/=/=/=/=/=/=/MenuLis=/=/=/=/=/=");
            out.println("1: Thêm Danh Bạn");
            out.println("2: Hiển Thị Thông Tin");
            out.println("3: Xoá Danh Bạ");
            out.println("4: Sửa Thông Tin");
            out.println("5: Tìm Kiếm");
            out.println("9: Saver File");
            out.println("0: Để Thoát");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    Contact contact = information.inputContact();
                    program.listContact.add(contact);
                    break;
                case 2:
                    Program.display(program.listContact);
                    break;
                case 3:
                    if (program.listContact.size() > 0) {
                        out.println("Nhap Ten: ");
                        String id = scan.nextLine();
                        boolean isDeleted = Program.remove(program.listContact, id);
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
                    if (program.listContact.size() > 0) {
                        out.println("Enter Name");
                        String id = scan.nextLine().trim();
                        Contact checks = Program.searchById(program.listContact, id);
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
                case 5:
                    if (program.listContact.size() > 0) {
                        String id = " ";
                        out.println("Nhap Ten ");
                        id = scan.nextLine().trim();
                        List<Contact> result = Program.SearchID(program.listContact, id);
                        if (result.size() > 0) {
                            out.println("Find " + result.size() + " Result");
                            Program.display(result);
                        } else {
                            out.println("==> Khong co Ten \"" + id + "\"");
                        }
                    } else {
                        out.println("Danh Ba trong");
                    }

                    break;
                case 9:
                    if (program.listContact.size() > 0) {
                        boolean isSuccess = Program.writeEmpToFile(program.listContact, program.empFileName);
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
