package bgrs;



import Messages.Message;
import bgu.spl.net.api.MessagingProtocol;
import resources.Database;

import java.util.LinkedList;
import java.util.List;


public class BgrsProtocol implements MessagingProtocol {

    private boolean shouldTerminate = false;
    private Database database;
    //@Override
    public String process(String msg)
    {
        int messageInd=0;
        byte[] message = msg.getBytes(); //new byte[2];
        byte[] two = new byte[2];
        two[0]=message[messageInd];
        messageInd++;
        two[1]=message[messageInd];
        messageInd++;

        short opcode = bytesToShort(two);
        //int opcode = this.toInt(msg.substring(0, 8));
        int courseNumber;
        String username, password;
        String errorMessage = "13";
//----------------------------------------------------- check if (opcode ==1) , if correct - duplicate it to the rest cases
        if (opcode == 1) // if opcode = 1
        {

            try {
                List<Byte> userName = new LinkedList<>();
                for(;messageInd<message.length & message[messageInd]!='0';messageInd++)
                {
                    userName.add(message[messageInd]);
                }
                messageInd++;//skip the zero
                Byte[] userNameBytes= (Byte[]) userName.toArray();


                List<Byte> passwordL = new LinkedList<>();
                for(;messageInd<message.length & message[messageInd]!='0';messageInd++)
                {
                    userName.add(message[messageInd]);
                }
                messageInd++;//skip the zero
                Byte[] passwordBytes= (Byte[]) passwordL.toArray();




                //database.RegisterAdmin(username,password);
            } catch (Exception e) {
                // send error message
                errorMessage = errorMessage + opcode;

            }

        }
        if (opcode == 2) {
            try {
                //database.StudentRegister(username,password);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;

            }
        }
        if (opcode == 3) {
            try {
                //database.login(username,password);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;

            }
        }
        if (opcode == 4) {
            try {
                //database.logout(connectedUser.username,connectedUser.password);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;


            }
        }
        if (opcode == 5) {
            try {
                //database.registerToCourse(courseNumber);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;

            }
        }
        if (opcode == 6) {
            try {
                // database.kdamCourse(courseNumber);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;

            }
        }
        if (opcode == 7) {
            try {
                //database.CourseSeats(courseNumber);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;

            }
        }
        if (opcode == 8) {
            try {
                // database.studentStat(username);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;

            }
        }
        if (opcode == 9) {
            try {
                //database.isRegisterd(courseNumber);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;

            }
        }
        if (opcode == 10) {
            try {
                //database.unregister(courseNumber);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;

            }
        }
        if (opcode == 11) {
            boolean flag = true;
            try {
                // database.myCourses(courseNumber);
            } catch (Exception e) {
                errorMessage = errorMessage + opcode;
                flag = false;

            }
            if (flag) {

            }
            // good message
        }


        shouldTerminate = "/n".equals(msg);
        return "";//have to change
    }

    //decode 2 bytes to short
    public short bytesToShort(byte[] byteArr)
    {
        short result = (short)((byteArr[0] & 0xff) << 8);
        result += (short)(byteArr[1] & 0xff);
        return result;
    }

    //encode 2 bytes to short
    public byte[] shortToBytes(short num)
    {
        byte[] bytesArr = new byte[2];
        bytesArr[0] = (byte)((num >> 8) & 0xFF);
        bytesArr[1] = (byte)(num & 0xFF);
        return bytesArr;
    }



    private int toInt(String substring) {
        int answer=0;
        if (substring.charAt(0)=='1')
            answer=answer+1;
        if (substring.charAt(1)=='1')
            answer=answer+2;
        if (substring.charAt(2)=='1')
            answer=answer+4;
        if (substring.charAt(3)=='1')
            answer=answer+8;

        return answer;

    }

    @Override
    public Object process(Object msg) {
        return null;
        //////have to implement
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }
}

