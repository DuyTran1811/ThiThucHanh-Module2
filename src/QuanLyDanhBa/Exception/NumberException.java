package QuanLyDanhBa.Exception;

public class NumberException extends Exception {
    private String PhoneNumber;

    public NumberException() {
    }

    public NumberException(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public NumberException(String message, String phoneNumber) {
        super(message);
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

}
