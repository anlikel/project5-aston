import exceptions.ReadWriteException;
import utils.Util;

public class Main
{
    public static void main( String[] args ) throws ReadWriteException {
        Program program=new Program();
        program.init();
            while(true) {
                try {
                    program.start();
                } catch (ReadWriteException e) {
                    Util.writeMessage(e.getMessage().toString());
                    program.start();
                }
            }
    }
}
