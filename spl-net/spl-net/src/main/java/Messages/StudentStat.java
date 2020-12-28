package Messages;

public class StudentStat implements Message {
    private int opcode;
    public StudentStat(int courseNumber)
    {
        this.opcode=8;
    }
    public void operation()
    {

    }
}
