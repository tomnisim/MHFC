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

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public int getCourseNumber() {
        return -1;
    }

    public String toString(){return "";}

    public String getUsername() {
        return username;
    }
}
