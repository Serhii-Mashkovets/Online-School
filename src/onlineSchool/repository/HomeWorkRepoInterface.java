package onlineSchool.repository;

import onlineSchool.models.*;

public interface HomeWorkRepoInterface {
    ParentingClassForModels[] getAll ();
    long size ();
    boolean isEmpty ();
    void add (ParentingClassForModels model);
    void add (int index, ParentingClassForModels model);
    void remove (int index);
}
