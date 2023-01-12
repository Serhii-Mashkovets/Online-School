package onlineSchool.repository;

import onlineSchool.models.Course;
import onlineSchool.models.ParentingClassForModels;

public class GeneralizationClass<E extends ParentingClassForModels> {
    private E[] elements;

    public GeneralizationClass(E[] elements) {
        this.elements = elements;
    }

    public GeneralizationClass(Course[] courseArray) {
    }

    public long size() {
        return elements.length;
    }

    public boolean isEmpty() {
        for (E element : elements) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }

    public E get(int index) {
        return elements[index - 1];
    }


    public void add(E element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                elements[i] = element;
                break;
            }
        }
    }

    public void add(int index, E element) {
        elements[index] = element;
    }

    public void remove(int index) {
        elements[index] = null;
    }

    public E[] getElements() {
        return elements;
    }

    public void setElements(E[] elements) {
        this.elements = elements;
    }
}
