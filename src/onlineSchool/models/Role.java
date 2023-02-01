package onlineSchool.models;

public enum Role {
    STUDENT, TEACHER;

    public Role EnumRoleName() {
        return Role.valueOf(name());
    }
}
