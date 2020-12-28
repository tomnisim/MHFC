package Messages;

public class ACKMessage implements Message {
    private int opcode;
    private int messageOpcose;
    public ACKMessage(int messageOpcose)
    {
        this.opcode=12;
        this.messageOpcose=messageOpcose;
    }
    public void operation()
    {

    }
}
