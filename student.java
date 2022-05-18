import java.io.Serializable;
import java.util.Objects;

public class student implements Serializable {

    private String firstName;  // Имя студента
    private String secondName;  // Фамилия студента
    private String teachPlace; // Место обучения (очно или заочно)
    private String gradesToStudent; //оценка

    public student(String firstName, String secondName,  String teachPlace, String gradesToStudent) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.teachPlace = teachPlace;
        this.gradesToStudent = gradesToStudent;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getFirstName() {
        return firstName;
    }

    // Обновить фамилию студента
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    // Получить фамилию студента
    public String getSecondName() {
        return secondName;
    }



    public void setTeachPlace(String teachPlace) {
        this.teachPlace = teachPlace;
    }



    public void setGradesToStudent(String gradesToStudent){
        this.gradesToStudent = gradesToStudent;
    }


    public String getTeachPlace() {
        return teachPlace;
    }

    public String getGradesToStudent() {
        return  gradesToStudent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return Objects.equals(firstName, student.firstName) && Objects.equals(secondName, student.secondName) && Objects.equals(teachPlace, student.teachPlace) && Objects.equals(gradesToStudent, student.gradesToStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, teachPlace, gradesToStudent);
    }

    @Override
    public String toString() {
        return "student{" +
               "firstName='" + firstName + '\'' +
               ", secondName='" + secondName + '\'' +
               ", teachPlace='" + teachPlace + '\'' +
               ", gradesToStudent='" + gradesToStudent + '\'' +
               '}';
    }
}


