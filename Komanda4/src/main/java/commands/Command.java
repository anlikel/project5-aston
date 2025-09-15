package commands;

import exceptions.ReadWriteException;

public interface Command {
    void execute() throws ReadWriteException;
}
