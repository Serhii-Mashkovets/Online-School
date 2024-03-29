package onlineSchool.repository;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ParentingClassForRepositories<ParentingClassForModels> {
    private static ParentingClassForRepositories newExample;

    public static ParentingClassForRepositories getNewExample() {
        if (newExample == null) {
            newExample = new ParentingClassForRepositories();
        }
        return newExample;
    }

    private List<ParentingClassForModels> elements;

    public long size() {
        return getElements().size();
    }

    public boolean isEmpty() {
        return getElements().isEmpty();
    }

    public Optional<ParentingClassForModels> get(int index) {
        return (Optional<ParentingClassForModels>) getElements().get(index - 1);
    }


    public void add(ParentingClassForModels element) {
        getElements().add(element);
    }

    public void add(int index, ParentingClassForModels element) {
        getElements().add(index, element);
    }

    public void remove(int index) {
        getElements().remove(index);
    }

    public List<ParentingClassForModels> getElements() {
        return elements;
    }

    public void setElements(List<ParentingClassForModels> elements) {
        this.elements = elements;
    }

    public void removeById(int studentId) {
    }
}