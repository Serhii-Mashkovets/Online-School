package onlineSchool.enums;

public enum Role {
    STUDENT,TEACHER;
    public Role EnumRoleName(){
        return Role.valueOf(name());
    }
}
