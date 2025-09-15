package model;

import enums.ClassTags;

import java.util.List;

public class Model<T> {
    private List<T> list;
    private List<T> elementList;
    private ClassTags tag;

    public <T>Model(ClassTags tag){
        this.tag=tag;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public ClassTags getTag() {
        return tag;
    }

    public List<T> getElementList() {
        return elementList;
    }

    public void setElementList(List<T> elementList) {
        this.elementList = elementList;
    }

    public void setTag(ClassTags tag) {
        this.tag = tag;
    }
}
