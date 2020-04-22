package Chan.BookShelvesMaven.Config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Configuration
public class QuerydslConfiguration {

	   @PersistenceContext
	    private EntityManager entityManager;

	    @Bean
	    public JPAQueryFactory jpaQueryFactory() {
	        return new JPAQueryFactory(entityManager);
	    }
	
  
	    
}
