package tw.group4.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//地位等同web.xml，第二行設定及連結過去的class取代mvc-servlet.xml
//這個class包含最基本的設定
//onStartup()內可設定Server服務啟動就連帶開啟的設定，包含過濾器
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
//	設定request response編碼的Filter
//	設定form method="post"轉"put"和"delete"的Filter
//	設定request response編碼的Filter當web.xml和java config同時設定，會失去作用，要用註冊filter方法設定
//	目前不明原因失效，先註解掉
	@Override
	protected Filter[] getServletFilters() {
//		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//		encodingFilter.setEncoding("UTF-8");
//		encodingFilter.setForceEncoding(true);
	    HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		
		return new Filter[] {hiddenHttpMethodFilter};
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringMVCConfig.class);
		rootContext.setServletContext(servletContext);
		ServletRegistration.Dynamic mvc = servletContext.addServlet("mvc", new DispatcherServlet(rootContext));
		mvc.setLoadOnStartup(1);
		mvc.addMapping("/");

//		這邊之後是設定過濾器映射路徑
//		第一個是開啟關閉Hibernate交易的filter，(被AOP取代，故註解)
//		FilterRegistration.Dynamic sessionFilterRegistration  = servletContext.addFilter("OpenSessionViewFilter", OpenSessionViewFilter.class);

//		設定啟動SessionFactory之InitParameter(不要解開註解)
//		sessionFilterRegistration.setInitParameter("sessionFactoryBeanName", "sessionFactory");

//		sessionFilterRegistration.addMappingForUrlPatterns(null, true, "*.ctrl");

//		加下面這行會害上面那行映射路徑設定失效(不要解開註解)
//		sessionFilterRegistration.addMappingForServletNames(null, true, "mvc");	
		
//		設定IdentityFilter (被AOP取代，故註解)
//		FilterRegistration.Dynamic identityFilterRegistration  = servletContext.addFilter("IdentityFilter", IdentityFilter.class);
//		identityFilterRegistration.addMappingForUrlPatterns(null, true, "/*");
		
//		編碼過濾器註冊
//		這是設定request編碼的方法二filter，設定context啟動時做什麼事
//		如果前面方法定義的過濾器因不明原因失效，要啟用這個過濾器代替
		FilterRegistration.Dynamic encodingFilterRegistration = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
		encodingFilterRegistration.setInitParameter("encoding", "UTF-8");
		encodingFilterRegistration.setInitParameter("forceEncoding", "true");
		encodingFilterRegistration.addMappingForUrlPatterns(null, false, "/*");

		servletContext.addListener(new ContextLoaderListener(rootContext));
	}

}
