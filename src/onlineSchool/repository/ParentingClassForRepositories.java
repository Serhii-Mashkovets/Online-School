package onlineSchool.repository;

import onlineSchool.models.ParentingClassForModels;


import java.util.List;

public abstract class ParentingClassForRepositories <E extends ParentingClassForModels> {
    private List<E> elements;

    public long size() {
        return getElements().size();
    }

    public boolean isEmpty() {
       return getElements().isEmpty();
    }

    public E get(int index) {
        return getElements().get(index - 1);
    }


    public void add(E element) {
        getElements().add(element);
    }

    public void add(int index, E element) {
        getElements().add(index, element);
    }

    public void remove(int index) {
        getElements().remove(index);
    }

    public List<E> getElements() {
        return elements;
    }

    public void setElements(List<E> elements) {
        this.elements = elements;
    }
}