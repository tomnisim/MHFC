package Messages;

public class MyCourses implements Message {
    private int opcode;
    public MyCourses(int courseNumber)
    {
        this.opcode=11;
    }
    public void operation()
    {

    }
}
