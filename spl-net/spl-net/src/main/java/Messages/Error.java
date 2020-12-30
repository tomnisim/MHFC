package Messages;

public class Error extends Message {
    private Integer opcode;
    private Integer messageOpcode;
    public Error(int messageOpcode)
    {
        this.opcode=13;
        this.messageOpcode=messageOpcode;
    }
    public void operation()
    {

    }
    public String toString(){
        String answer = opcode.toString()+messageOpcode.toString();
        return answer;
    }
}
