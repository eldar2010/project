import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class course implements Serializable {
    private String courseName;
    private int houreNum;

    public Map<student, String> students = new HashMap<>();

    public course(String newCourseName, int newHoureNum) {
        this.courseName = newCourseName;
        this.houreNum = newHoureNum;
    }

    // Задать новое имя
    public void setCourseName(String newCourseName){
        this.courseName = newCourseName;
    }

    // Получить имеющееся курсы
    public String getCourseName() {
        return courseName;
    }

    // Обновить кол-во часов
    public void setHoureNum(int houreNum) {
        this.houreNum = houreNum;
    }

    //  кол-во часов
    public int getHoureNum() {
        return houreNum;
    }

    public Map<student, String> getStudents() {
        return students;
    }

    public void setStudents(Map<student, String> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "course{" +
               "courseName='" + courseName + '\'' +
               ", houreNum=" + houreNum +
               ", students=" + students +
               '}';
    }
}


