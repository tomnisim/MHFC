package Messages;

public class Login extends Message {
    private int opcode;
    private String userName;
    private String password;
    public Login(String userName, String password)
    {
        this.opcode=3;
        this.userName=userName;
        this.password=password;
    }
    public void operation()
    {

    }
    public String toString()
    {
        return "";
    }
}
