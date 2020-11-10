package QuanLyDanhBa;

import QuanLyDanhBa.Exception.NumberException;

import java.util.Scanner;

public class InputInformation {
    public Contact inputContact() throws NumberException {
        Scanner input = new Scanner(System.in);
        System.out.println("So Dien Thoai");
        String phone = input.nextLine();
        System.out.println("Nhom");
        String group = input.nextLine();
        System.out.println("Ten");
        String name = input.nextLine();
        System.out.println("Gioi Tinh");
        String gioTinh = input.nextLine();
        System.out.println("Dia Chi");
        String address = input.nextLine();
        System.out.println("Ngay Thang Nam Sinh");
        String dateOfBirth = input.nextLine();
        System.out.println("Email");
        String email = input.nextLine();
        return new Contact(phone, group, name, gioTinh, address, dateOfBirth, email);
    }
}
