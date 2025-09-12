package commands;

import utils.FileObjectSave;

public class WriteCommand implements Command{
    @Override
    public void execute() {
        FileObjectSave.saveListToFile();
    }
}
