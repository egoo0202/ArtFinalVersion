//package tw.group4.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//import tw.group4.util.AOPforHibernate;
//
////用Java方式啟用AOP
////目前這個設定移動到SpringMVCConfig
//@Configuration
//@EnableAspectJAutoProxy
//沒設定這個Spring找不到你用註釋註冊好的方法啊，已在SrpinMVCConfig設定
//@ComponentScan(basePackages = "tw.group4" )
//public class AOPConfig {
//	
////	設定定義AOP方法的class
//	@Bean
//	public AOPforHibernate getAOPforHibernate() {
//		return new AOPforHibernate();
//	}
//}
