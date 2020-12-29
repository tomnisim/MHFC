package resources;


import resources.Admin;
import resources.Course;
import resources.Student;
import resources.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Passive object representing the Database where all courses and users are stored.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add private fields and methods to this class as you see fit.
 */
public class Database {


    //to prevent user from creating new Database

    private HashMap<Integer, Course> courselist;
    private HashMap<String, Admin> adminsList;
    private HashMap<String, Student> studentsList;
    private static class SingletonHolder {
        private static Database instance = new Database();
    }
    private Database() {
        adminsList = new HashMap<String, Admin>();
        studentsList = new HashMap<String, Student>();
        courselist = new HashMap<Integer, Course>();


    }
    /**
     * Retrieves the single instance of this class.
     */
    public static Database getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * loades the courses from the file path specified
     * into the Database, returns true if successful.
     */
    boolean initialize(String coursesFilePath) {
        String courses = coursesFilePath; // have to read from the file and create a string that contains all the course info
        int courseNum=0;
        String courseName="";
        String kdamCourseList="";
        int numOfMaxStudents=0;
        int place=0;
        List<Integer> kdamCourse;
        while (courses.indexOf("|")!=-1)
        {
            place = courses.indexOf('|');
            if (place == -1)
            {
                break;// check that it is get out of the function
            }
            else
            {
                String courseN = courses.substring(0, place - 1);//check if it include the end of the range
                courses = courses.substring(place + 1);
                courseNum = stringToInt(courseN);
            }
            place = courses.indexOf('|');
            if (place == -1) {
                break;// check that it is get out of the function
            }
            else
            {
                courseName = courses.substring(0, place - 1);//check if it include the end of the range
                courses = courses.substring(place + 1);
            }
            place = courses.indexOf('|');
            if (place == -1) {
                break;// check that it is get out of the function
            }
            else
            {
                kdamCourseList = courses.substring(0, place - 1);//check if it include the end of the range
                kdamCourse = stringToListInt(kdamCourseList);
                courses = courses.substring(place + 1);
            }
            place = courses.indexOf('|');
            if (place == -1) {
                break;// check that it is get out of the function
            }
            else
            {
                String numOfMS = courses.substring(0, place - 1);//check if it include the end of the range
                courses = courses.substring(place + 1);
                numOfMaxStudents = stringToInt(numOfMS);
            }
            Course course=new Course(courseNum,courseName,numOfMaxStudents,kdamCourse);
            courselist.put(courseNum, course);


        }//while




        // TODO: implement
        // admin
        // students
        // courses
        return false;
    }
    private List<Integer> stringToListInt(String s)
    {
        String sCopy=s;
        sCopy=sCopy.substring(1,sCopy.length()-1);//remove the []
        List<Integer> ans = new LinkedList<>();
        while (sCopy.contains(","))
        {
            int place=sCopy.indexOf(',');
            ans.add(stringToInt(sCopy.substring(0,place-1)));
            sCopy=sCopy.substring(place+1);
        }
        if (sCopy.length()>0)
        {
            ans.add(stringToInt(sCopy));
        }
        return ans;
    }

    private int stringToInt(String s)
    {
        int pow=0;
        int ans=0;
        for (int i=s.length()-1;i>=0 ;i--)
        {
            ans=ans+((s.charAt(i)-'0')*(int)Math.pow(10,pow));
            pow++;
        }
        return ans;


    }

    public void RegisterAdmin (String username, String password)
    {
        if (adminsList.containsKey(username) | studentsList.containsKey(username))
            throw new IllegalArgumentException("username is already registered");
        adminsList.put(username,new Admin(username,password));

    }
    public void StudentRegister(String username, String password) {
        if (adminsList.containsKey(username) | studentsList.containsKey(username))
            throw new IllegalArgumentException("username is already registered");
        studentsList.put(username,new Student(username,password));

    }

    public User login(String username, String password) {
        // no such a user
        if (!adminsList.containsKey(username) & !studentsList.containsKey(username))
            throw new IllegalArgumentException("there is no such an user");
        User user=null;
        if (adminsList.containsKey(username))
            user = adminsList.get(username);
        if (studentsList.containsKey(username))
            user = studentsList.get(username);
        // wrong password
        if (user.getPassword()!=password)
            throw new IllegalArgumentException("wrong password");
        // already login
        if (user.getStatus())
            throw new IllegalArgumentException("the user is already logged in");
        // login
        user.login();
        return user;
    }

    public void logout(String username, String password) {
        // no such a user
        if (!adminsList.containsKey(username) & !studentsList.containsKey(username))
            throw new IllegalArgumentException("there is no such an user");
        User user=null;
        if (adminsList.containsKey(username))
            user = adminsList.get(username);
        if (studentsList.containsKey(username))
            user = studentsList.get(username);
        // wrong password
        if (user.getPassword()!=password)
            throw new IllegalArgumentException("wrong password");
        // already login
        if (!user.getStatus())
            throw new IllegalArgumentException("the user is not logged in");
        // logout
        user.logout();
    }
    public void registerToCourse(String userName,int courseNumber)
    {
        // no such a course
        if (!courselist.containsKey(courseNumber))
            throw new IllegalArgumentException("no such a course");
        // no seats available
        Course course = courselist.get(courseNumber);
        if (course.getSeatsAvailable()==0)
            throw new IllegalArgumentException("no seats available");
        // student doesnt complete kdamCourse
        // the student isnt login
        if(true)
        {

        }
        // admin cant register to course
    }
    public String kdamCheck(int courseNumber) {
        if (!courselist.containsKey(courseNumber))
            throw new IllegalArgumentException("there is not such a course");
        courselist.get(courseNumber).getKdam();

    }

    public String CourseStat(int courseNumber) {


    }

    public String studentStat(String username) {

    }

    public boolean isRegisterd(String userName,int courseNumber) {
    }

    public boolean unregister(String usreName,int courseNumber) {
    }

    public String myCourses(String userName) {
    }
    private String listToString(List<Integer> list) {
        // have to implement
        return "";
    }

}
