package main.java;

import main.java.exceptions.ReadWriteException;
import main.java.utils.Util;

public class Main
{
    public static void main( String[] args ) throws ReadWriteException {
        Program program=new Program();
        program.init();
            while(true) {
                try {
                    program.start();
                } catch (ReadWriteException e) {
                    Util.writeMessage(e.toString());
                    program.start();
                }

            }
    }
}
