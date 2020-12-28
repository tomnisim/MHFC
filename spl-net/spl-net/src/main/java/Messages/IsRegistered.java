package Messages;

public class IsRegistered implements Message {
    private int opcode;
    private int courseNumber;
    public IsRegistered(int courseNumber)
    {
        this.opcode=9;
        this.courseNumber=courseNumber;
    }
    public void operation()
    {

    }
}
