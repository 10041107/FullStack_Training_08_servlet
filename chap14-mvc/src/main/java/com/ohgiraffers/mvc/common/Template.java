package com.ohgiraffers.mvc.common;

import com.mysql.cj.Session;
import com.mysql.cj.jdbc.JdbcConnection;
import com.ohgiraffers.mvc.employee.dao.EmpMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.servlet.annotation.WebFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSession(){

        if(sqlSessionFactory == null){
            Properties properties = new Properties();
            try {
                properties.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));
                String driver = properties.getProperty("driver");
                String url  = properties.getProperty("url");
                String user = properties.getProperty("user");
                String pass  = properties.getProperty("pass");

                Class.forName(driver);


                Environment environment = new Environment(
                        "dev",
                        new JdbcTransactionFactory(),
                        new PooledDataSource(driver,url, user,pass)
                );
                Configuration configuration = new Configuration(environment);
                // 메퍼 등록
                configuration.addMapper(EmpMapper.class);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return sqlSessionFactory.openSession(false);
    }

}
