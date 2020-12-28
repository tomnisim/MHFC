package Messages;

public class Error implements Message {
    private int opcode;
    private int messageOpcose;
    public Error(int messageOpcose)
    {
        this.opcode=13;
        this.messageOpcose=messageOpcose;
    }
    public void operation()
    {

    }
}
