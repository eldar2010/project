import java.io.Serializable;
import java.util.ArrayList;

public class prepod implements Serializable {
    private String firstName;  // Имя преподавателя
    private String secondName;  // Фамилия преподавателя
    private String address;  // предмет обучения

    public ArrayList<course> prepodCourse = new ArrayList<>();


    public prepod(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;


    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getAddress() {
        return address;
    }
}

