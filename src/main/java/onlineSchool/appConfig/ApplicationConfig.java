package onlineSchool.appConfig;


import onlineSchool.repository.AddMaterialsRepository;
import onlineSchool.repository.StudentsRepository;
import onlineSchool.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.sql.DataSource;
import java.util.Properties;
import java.util.Scanner;

@Configuration
@ComponentScan ("onlineSchool")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Autowired
    private Environment env;


    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;



    @Autowired
    AddMaterialsRepository addMaterialsRepository;

    @Autowired
    StudentsRepository studentsRepository;

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
        return new StudentsService(studentsRepository, scanner ());
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }



    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        return dataSource;
    }



    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(
                env.getRequiredProperty("onlineSchool.persistanceObjects"));
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }


    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

}
