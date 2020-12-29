package bgrs;

import Messages.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MessageEncoderDecoder  {
    private byte[] bytes = new byte[1 << 10]; //start with 1k
    private int opcode;
    private int messageInd = 0;

    //@Override
    public Message decodeNextByte(byte nextByte) {
        //notice that the top 128 ascii characters have the same representation as their utf-8 counterparts
        //this allow us to do the following comparison


        if (nextByte == '\n') {
            return decodeAllBytes();
        }

        pushByte(nextByte);
        return null; //not a line yet



    }

    //@Override
    public byte[] encode(Message message) {
        return (message.toString() + "\n").getBytes(); //uses utf8 by default
    }

    private void pushByte(byte nextByte) {
        if (messageInd >= bytes.length) {
            bytes = Arrays.copyOf(bytes, messageInd * 2);
        }

        bytes[messageInd++] = nextByte;
    }


    private Message decodeAllBytes(){

        // decoding opcode
        byte[] two = new byte[2];
        two[0]=bytes[messageInd];
        messageInd++;
        two[1]=bytes[messageInd];
        messageInd++;
        opcode = bytesToShort(two);
        byte[] userNameBytes = new byte[1 << 10];
        byte[] passwordBytes = new byte[1 << 10];
        byte[] courseBytes = new byte[1 << 10];

        if (opcode==1) {
             // first kind of message
             String username, password; // by the bytes
             // decoding username
             int index=0;
             while (bytes[messageInd] != (byte) 0) {
                 userNameBytes[index]=(bytes[messageInd]);
                 index++;
                 messageInd++;
             }
             messageInd++;
             username = new String(userNameBytes,0,messageInd,StandardCharsets.UTF_8);
             //decoding password
            index=0;
            while (bytes[messageInd] != (byte) 0) {
                passwordBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }
            messageInd++;

            password = new String(passwordBytes,0,messageInd,StandardCharsets.UTF_8);
             return new AdminReg(username, password);

         }
        if (opcode==2) {
            String username, password; // by the bytes
            // decoding username
            int index=0;
            while (bytes[messageInd] != (byte) 0) {
                userNameBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }
            messageInd++;

            username = new String(userNameBytes,0,messageInd,StandardCharsets.UTF_8);
            //decoding password
            index=0;
            while (bytes[messageInd] != (byte) 0) {
                passwordBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }
            messageInd++;

            password = new String(passwordBytes,0,messageInd,StandardCharsets.UTF_8);
            return new StudentReg(username, password);

        }
        if (opcode==3) {
            // first kind of message
            String username, password; // by the bytes
            // decoding username
            int index=0;
            while (bytes[messageInd] != (byte) 0) {
                userNameBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }
            messageInd++;

            username = new String(userNameBytes,0,messageInd,StandardCharsets.UTF_8);
            //decoding password
            index=0;
            while (bytes[messageInd] != (byte) 0) {
                passwordBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }
            messageInd++;

            password = new String(passwordBytes,0,messageInd,StandardCharsets.UTF_8);
            return new Login(username, password);

        }
        if (opcode==4) {

            return new Logout();

        }
        if (opcode==5) {
            String courseNumber;
            int index=0;
            while (bytes[messageInd] != (byte) '\n') {
                courseBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }

            courseNumber = new String(courseBytes,0,messageInd,StandardCharsets.UTF_8);

            return new CourseReg(stringToInt(courseNumber));

        }
        if (opcode==6) {
            String courseNumber;
            int index=0;
            while (bytes[messageInd] != (byte) '\n') {
                courseBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }

            courseNumber = new String(courseBytes,0,messageInd,StandardCharsets.UTF_8);

            return new KdamCheck(stringToInt(courseNumber));

        }
        if (opcode==7) {
            String courseNumber;
            int index=0;
            while (bytes[messageInd] != (byte) '\n') {
                courseBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }

            courseNumber = new String(courseBytes,0,messageInd,StandardCharsets.UTF_8);

            return new CourseStat(stringToInt(courseNumber));

        }
        if (opcode==8) {
            String userName;
            int index=0;
            while (bytes[messageInd] != (byte) '0') {
                userNameBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }
            messageInd++;

            userName = new String(userNameBytes,0,messageInd,StandardCharsets.UTF_8);

            return new StudentStat(userName);

        }
        if (opcode==9) {
            String courseNumber;
            int index=0;
            while (bytes[messageInd] != (byte) '\n') {
                courseBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }

            courseNumber = new String(courseBytes,0,messageInd,StandardCharsets.UTF_8);

            return new IsRegistered(stringToInt(courseNumber));

        }
        if (opcode==10) {
            String courseNumber;
            int index=0;
            while (bytes[messageInd] != (byte) '\n') {
                courseBytes[index]=(bytes[messageInd]);
                index++;
                messageInd++;
            }

            courseNumber = new String(courseBytes,0,messageInd,StandardCharsets.UTF_8);

            return new UnRegister(stringToInt(courseNumber));

        }
        if (opcode==11) {

            return new MyCourses();

        }

        return null;

    }

    private int stringToInt(String s) {
        int pow=0;
        int ans=0;
        for (int i=s.length()-1;i>=0 ;i--)
        {
            ans=ans+((s.charAt(i)-'0')*(int)Math.pow(10,pow));
            pow++;
        }
        return ans;


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
}

