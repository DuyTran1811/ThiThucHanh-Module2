package QuanLyDanhBa;

import QuanLyDanhBa.Exception.NumberException;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact implements Serializable {
    private String phoneNumber;
    private String Group;
    private String name;
    private String giotinh;
    private String address;
    private String dateOfBirth;
    private String email;

    public Contact() {
    }

    public Contact(String phoneNumber, String group, String name, String giotinh, String address, String dateOfBirth, String email) throws NumberException {
       this.setPhoneNumber(phoneNumber);
        Group = group;
        this.name = name;
        this.giotinh = giotinh;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws NumberException {
        String regex = "^((08|09)\\d{7})|((03|04|07)\\d{8})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()){
            this.phoneNumber = phoneNumber;
        }else {
            String smg = "Invalid PhoneNumber: " +phoneNumber;
            throw new NumberException(smg,phoneNumber);
        }
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiotinh() {
        return giotinh;
    }

    public void setGiotinh(String giotinh) {
        this.giotinh = giotinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
