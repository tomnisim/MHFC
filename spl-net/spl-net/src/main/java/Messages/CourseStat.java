package Messages;

public class CourseStat implements Message {
    private int opcode;
    private int courseNumber;
    public CourseStat(int courseNumber)
    {
        this.opcode=7;
        this.courseNumber=courseNumber;
    }
    public void operation()
    {

    }
}
