package Messages;

public class ACKMessage extends Message {
    private Integer opcode;
    private Integer messageOpcode;
    private String description;


    public ACKMessage(int messageOpcode,String description)
    {
        this.opcode=12;
        this.messageOpcode=messageOpcode;
        this.description=description;
    }
    public void operation()
    {

    }
    public String toString()
    {
        String answer;
        answer=opcode.toString()+messageOpcode.toString()+description+"0";
        return answer;
    }
}
