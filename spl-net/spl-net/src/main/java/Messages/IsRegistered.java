package Messages;

public class IsRegistered extends Message {
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
    public String toString()
    {
        return "";
    }
}
