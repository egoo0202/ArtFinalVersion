package tw.group4.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilNoWeb {
	
	private static final SessionFactory factory = createSessionFactory();
	
	private static SessionFactory createSessionFactory() {
		SessionFactory factory = null;
		try {
			//先初始化，載入hibernate.cfg.xml設定
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.noweb.xml").build();
			//接著，建Metadata再建SessionFactory
			factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			return factory;
		} catch (Exception e) {
			//如果出錯，印出stacktrace，return沒取得連線，值為null的factory
			e.printStackTrace();
			return factory;
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}

}
