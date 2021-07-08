package com.laonstory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CcProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcProjApplication.class, args);
	}

	/*
     * SqlSessionFactory ¼³Á¤ 
     
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
	}
	 */
}
