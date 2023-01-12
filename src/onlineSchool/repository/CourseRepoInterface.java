package onlineSchool.repository;

import onlineSchool.models.*;

public interface CourseRepoInterface {
Course[] getAll ();
long size ();
boolean isEmpty ();
void add (ParentingClassForModels model);
void add (int index, ParentingClassForModels model);
void remove (int index);
}
