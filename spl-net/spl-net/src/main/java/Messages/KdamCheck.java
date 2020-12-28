package Messages;

public class KdamCheck implements Message {
    private int opcode;
    private int courseNumber;
    public KdamCheck(int courseNumber)
    {
        this.opcode=6;
        this.courseNumber=courseNumber;
    }
    public void operation()
    {

    }
}
