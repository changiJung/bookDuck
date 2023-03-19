package Chan.BookShelvesMaven.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    // dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
    // dataSource.setUsername("bookduck");
    // dataSource.setPassword("asd4r3e2w1q");
    // dataSource.setUrl(
    // "jdbc:mariadb://222.237.83.123:32000/BOOKDUCK?useUnicode=true&characterEncoding=utf8");

    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUsername("sa");
    dataSource.setPassword("");
    dataSource.setUrl(
        "jdbc:h2:~/testdb");

    return dataSource;
  }

}