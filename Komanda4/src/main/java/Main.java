import MultiFind.FindCountElements;
import exceptions.ReadWriteException;
import utils.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
