package controller;

import model.Model;

public class Controller {
    private Model model;
    public Controller(){}

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}
