package Messages;

public class AdminReg implements Message {
    private int opcode;
    private String userName;
    private String password;
    public AdminReg(String userName, String password)
    {
        this.opcode=1;
        this.userName=userName;
        this.password=password;
    }
    public void operation()
    {

    }
}
