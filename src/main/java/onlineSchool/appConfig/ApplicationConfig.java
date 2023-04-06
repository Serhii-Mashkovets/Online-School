package onlineSchool.appConfig;


import onlineSchool.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan ("onlineSchool")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {


    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

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
