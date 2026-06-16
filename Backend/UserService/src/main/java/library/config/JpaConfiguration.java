package library.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "library.repository")
@PropertySource("classpath:application.properties")


public class JpaConfiguration {
	@Value("${db.username}")
	private String username;
	@Value("${db.url}")
	private String url;
	@Value("${db.password}")
	private String password;
	@Bean
	public DataSource dataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername(username);
		ds.setJdbcUrl(url);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("library.data");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties pro = new Properties();
		pro.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		pro.setProperty("hibernate.hbm2ddl.auto", "update");
		pro.setProperty("hibernate.format_sql", "true");
		em.setJpaProperties(pro);
		return em;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}





