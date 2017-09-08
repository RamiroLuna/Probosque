package org.probosque.database.interfaces;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;



public class DataBaseProgram implements PoolDataSource{
 DataSource[] source= new DataSource[9];
 BasicDataSource bds = new BasicDataSource();
 

    @Override
    public QueryRunner getDataBaseProgram(Integer program) {
            bds.setPoolPreparedStatements(true);
            bds.setMaxOpenPreparedStatements(5);            
            switch(program){
                case 0:
                      bds.setDriverClassName("org.postgresql.Driver");
                      bds.setUrl("jdbc:postgresql://localhost:5432/programa8");
                      bds.setUsername("programa8");
                      bds.setPassword("programa8_ZXCVMNQ12");                      
                     break;
                case 1:
                      bds.setDriverClassName("org.postgresql.Driver");
                      bds.setUrl("jdbc:postgresql://localhost:5432/programa1");
                      bds.setUsername("programa1");
                      bds.setPassword("programa1_Ak457fgyt");                      
                    break;
                case 8:
                      bds.setDriverClassName("org.postgresql.Driver");
                      bds.setUrl("jdbc:postgresql://localhost:5432/programa8");
                      bds.setUsername("programa8");
                      bds.setPassword("programa8_ZXCVMNQ12");
                     break;            
            }
            source[program] =  bds;
            QueryRunner qr = new QueryRunner(source[program]);
            return qr;            
    }
    
}
