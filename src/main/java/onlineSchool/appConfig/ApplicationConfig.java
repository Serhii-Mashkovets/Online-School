package onlineSchool.appConfig;


import onlineSchool.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public AddMaterialService addMaterialService() {
        return new AddMaterialService();
    }

    @Bean
    public HomeWorkService homeWorkService() {
        return new HomeWorkService();
    }

    @Bean
    public CourseService courseService() {
        return new CourseService();
    }

    @Bean
    public LectureService lectureService() {
        return new LectureService();
    }

    @Bean
    public PersonService personService() {
        return new PersonService();
    }

    @Bean
    public TeachersService teachersService() {
        return new TeachersService();
    }

    @Bean
    public StudentsService studentsService() {
        return new StudentsService();
    }





}
