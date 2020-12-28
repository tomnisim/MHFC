package Messages;

public class UnRegister implements Message {
    private int opcode;
    private int courseNumber;
    public UnRegister(int courseNumber)
    {
        this.opcode=10;
        this.courseNumber=courseNumber;
    }
    public void operation()
    {

    }
}
