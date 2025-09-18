package classfillers;

import exceptions.ReadWriteException;

import java.util.List;

public interface Filling<T> {
    List<T> manualFill(int size) throws ReadWriteException;
    List<T> randomFill(int size);
    List<T> autoFill() throws ReadWriteException;
}
