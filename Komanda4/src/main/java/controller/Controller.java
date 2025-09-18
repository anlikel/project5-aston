package controller;

import enums.ClassTags;
import model.Model;

import java.util.List;

public class Controller {
    private Model model;

    public Controller() {}

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setList(List list) {
        if (model != null) {
            model.setList(list);
        }
    }

    public List getList() {
        return model != null ? model.getList() : null;
    }

    public List getElementList() {
        return model != null ? model.getElementList() : null;
    }

    public void setElementList(List elementList) {
        if (model != null) {
            model.setElementList(elementList);
        }
    }

    public List getFoundedList() {
        return model != null ? model.getFoundedList() : null;
    }

    public List getTempList() {
        return model != null ? model.getTempList() : null;
    }

    public void setTempList(List tempList) {
        if (model != null) {
            model.setTempList(tempList);
        }
    }

    public void setFoundedList(List foundedList) {
        if (model != null) {
            model.setFoundedList(foundedList);
        }
    }

    public ClassTags getTag() {
        return model != null ? model.getTag() : null;
    }
}