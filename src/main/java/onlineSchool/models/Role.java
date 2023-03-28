package onlineSchool.models;

import java.io.Serializable;

public enum Role implements Serializable {
    STUDENT, TEACHER;

    public Role EnumRoleName() {
        return Role.valueOf(name());
    }
}
