package Messages;

public class StudentReg implements Message {
    private int opcode;
    private String userName;
    private String password;
    public StudentReg(String userName, String password)
    {
        this.opcode=2;
        this.userName=userName;
        this.password=password;
    }
    public void operation()
    {

    }
}
