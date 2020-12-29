package Messages;

public class CourseStat extends Message {
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
    public String toString()
    {
        return "";
    }
}
