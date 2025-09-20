package classfillers;

import exceptions.ReadWriteException;

import java.util.List;

public class UniversalFiller {
    private Filling filling;

    public UniversalFiller(Filling filling){
        this.filling=filling;
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }

    public List manualFill(int size) throws ReadWriteException {
        return filling.manualFill(size);
    }

    public List randomFill(int size) throws ReadWriteException {
        return filling.randomFill(size);
    }

    public List autoFill() throws ReadWriteException {
        return filling.autoFill();
    }
}
