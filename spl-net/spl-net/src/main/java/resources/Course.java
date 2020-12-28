package resources;


import java.util.LinkedList;
import java.util.List;

public class Course {
    private int id;
    private String name;
    private int numOfMaxStudents;
    private int seatAvailable;
    private List<Student> studentsRegistered;
    private List<Integer> kdamCoursesList;

    public Course(int id,String name,int numOfMaxStudents,List<Integer> kdamCoursesList){
        this.name=name;
        this.id=id;
        this.numOfMaxStudents=numOfMaxStudents;
        this.kdamCoursesList=kdamCoursesList;
        this.seatAvailable=numOfMaxStudents;
        this.studentsRegistered = new LinkedList<Student>();
    }

    public String getKdam() {
        String answer="";

        return answer;
    }

    public int getSeatsAvailable() {
        return -1;//////////implement
    }
}
