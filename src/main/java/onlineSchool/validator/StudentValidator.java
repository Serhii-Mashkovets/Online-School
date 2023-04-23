package onlineSchool.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import onlineSchool.models.Student;
import org.springframework.core.env.Environment;
import org.springframework.validation.Errors;


import java.util.Set;

public class StudentValidator implements Validator {

    private Validator validator;
    private Environment env;

    public StudentValidator(Validator validator, Environment env) {
        this.validator = validator;
        this.env = env;
    }


    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }


    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> violations = validator.validate(target);
        for (ConstraintViolation<Object> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.rejectValue(propertyPath, "", message);
        }
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validate(T t, Class<?>... classes) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateProperty(T t, String s, Class<?>... classes) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateValue(Class<T> aClass, String s, Object o, Class<?>... classes) {
        return null;
    }

    @Override
    public BeanDescriptor getConstraintsForClass(Class<?> aClass) {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public ExecutableValidator forExecutables() {
        return null;
    }
}

