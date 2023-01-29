package onlineSchool.repository;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.*;
import onlineSchool.services.SimpleIterator;

public interface LectureRepoInterface {
    ParentingClassForModels[] getAll();

    long size();

    boolean isEmpty();

    void add(ParentingClassForModels model);

    void add(int index, ParentingClassForModels model);

    void remove(int index);

    void findAll() throws EntityNotFoundException;

    SimpleIterator<Lecture> iterator();
}
