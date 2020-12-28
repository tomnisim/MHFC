package Messages;

public class CourseReg implements Message {
    private int opcode;
    private int courseNumber;
    public CourseReg(int courseNumber)
    {
        this.opcode=5;
        this.courseNumber=courseNumber;
    }
    public void operation()
    {

    }
}
