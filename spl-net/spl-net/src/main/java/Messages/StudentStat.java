package Messages;

public class StudentStat extends Message {
    private int opcode;
    private String username;
    public StudentStat(String userName)
    {
        this.opcode=8;
        this.username=userName;
    }
    public void operation()
    {

    }
    public String toString(){return "";}

    public String getUsername() {
        return username;
    }
}
