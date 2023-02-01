package onlineSchool.services;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.ParentingClassForModels;

public class SimpleIterator<E extends ParentingClassForModels> {
    private Integer index;

    private Integer deleteIndex = -1;
    private E[] arrayOfElements;

    public SimpleIterator(E[] arrayOfelements) {
        arrayOfElements = arrayOfelements;
    }

    public boolean hasNext() {
        return !(index == arrayOfElements.length
                || index < 0
                || arrayOfElements[index] == null);
    }

    public E next() throws EntityNotFoundException {
        if (index < 0 || arrayOfElements[index] == null) {
            throw new EntityNotFoundException("Елемент не знайдено!");
        }
        deleteIndex = index;
        return arrayOfElements[index++];
    }

    public void remove() {
        if (deleteIndex != index - 1) {
            throw new IllegalStateException();
        } else {
            arrayOfElements[deleteIndex] = null;
            for (int i = 0; i < arrayOfElements.length - 1; i++) {
                if (arrayOfElements[i] == null) {
                    arrayOfElements[i] = arrayOfElements[i + 1];
                    arrayOfElements[i + 1] = null;
                }
            }
        }
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getDeleteIndex() {
        return deleteIndex;
    }

    public void setDeleteIndex(Integer deleteIndex) {
        this.deleteIndex = deleteIndex;
    }
}
