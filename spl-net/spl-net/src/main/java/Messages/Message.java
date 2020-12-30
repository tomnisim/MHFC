package Messages;

public abstract class Message {
    private int opcode;
    public int getOpcode(){return opcode;}

    public abstract void operation();
    public abstract String toString();
    public abstract String getUser();
    public abstract String getPassword();
    public abstract int getCourseNumber();

}
