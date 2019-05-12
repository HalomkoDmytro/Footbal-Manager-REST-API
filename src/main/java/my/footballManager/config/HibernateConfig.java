package my.footballManager.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

@Configuration
@EnableTransactionManagement
@ComponentScan({"my.footballManager.config"})
@PropertySource("classpath:postgres.properties")
public class HibernateConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"my.footballManager.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("postgres.driverClassName"));
        dataSource.setUrl(environment.getProperty("postgres.url"));
        dataSource.setUsername(environment.getProperty("postgres.user"));
        dataSource.setPassword(environment.getProperty("postgres.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(DIALECT, environment.getProperty("hibernate.dialect"));
        properties.put(SHOW_SQL, environment.getProperty("hibernate.showSql"));
        properties.put(FORMAT_SQL, environment.getProperty("hibernate.formatSql"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emf
                = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setJpaProperties(hibernateProperties());
        emf.setPackagesToScan("my.footballManager.model");
        return emf;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }


}