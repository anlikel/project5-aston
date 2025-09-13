package commands;

import utils.FileObjectSave;

public class WriteCommand implements commands.Command {
    @Override
    public void execute() {
        FileObjectSave.saveListToFile();
    }
}
