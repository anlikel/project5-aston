package model;

import java.util.List;

public class Model<T> {
    private List<T> list;

    public <T>Model(){}

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }
}
