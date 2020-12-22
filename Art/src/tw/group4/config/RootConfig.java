package tw.group4.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//這個class設定TransactionManager和Hibernate
@Configuration
@EnableTransactionManagement
//@PropertySource("classpath:jdbc.properties")
public class RootConfig {
	
	Environment env;
	
	@Autowired
	public void setEnv(Environment env) {
		this.env = env;
	}

	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		jndiBean.setJndiName("java:comp/env/jdbc/xe");		
		jndiBean.setProxyInterface(DataSource.class);
		jndiBean.setLookupOnStartup(false);
		jndiBean.afterPropertiesSet();
		DataSource ds = (DataSource)jndiBean.getObject();
		System.out.println("ds:" + ds);
		
//		ComboPooledDataSource ds = new ComboPooledDataSource();
//		ds.setUser(env.getProperty("spring.database.user"));
//		ds.setPassword(env.getProperty("spring.database.password"));
//		try {
//			ds.setDriverClass(env.getProperty("spring.database.driverclass"));
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}
//		ds.setJdbcUrl(env.getProperty("spring.database.url"));
//		ds.setInitialPoolSize(Integer.parseInt((env.getProperty("spring.database.initialpoolsize"))));
//		ds.setMaxPoolSize(Integer.parseInt((env.getProperty("spring.database.maxpoolsize"))));
		return ds;
	}
	
	@Bean(destroyMethod = "destroy")
	public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] { "tw.group4" });
		factory.setHibernateProperties(additionalProperties());
		return factory;
	}
	
	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.Oracle12cDialect.class);
		properties.put("hibernate.show_sql", Boolean.TRUE);
		properties.put("hibernate.format_sql", Boolean.TRUE);
		properties.put("hibernate.current_session_context_class", "thread");
//		下方這句是關於預設batch_fetch_size
//		properties.put("default_batch_fetch_size", 10);
//		批次讀取批次寫入設定，讀50，寫30
		properties.put("hibernate.jdbc.fetch_size", 50);
		properties.put("hibernate.jdbc.batch_size", 30);
//		下方這句是關於hibernate插入資料時自動建立表格
//		properties.put("hibernate.hbm2ddl.auto", "validate");
		return properties;
	}
	
	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
}
