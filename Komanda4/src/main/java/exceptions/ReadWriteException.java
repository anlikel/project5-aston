package exceptions;

import java.io.IOException;

public class ReadWriteException extends Exception {
    String message;
    public ReadWriteException(String message){
        super(message);
    }
}
