/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.dao;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author Erick_G
 */
public class PoolDataSource {

    private static DataSource[] dataSource = new DataSource[16];
    public static final String[] userAndDatabase = {
        "programageneral"};

    public static final String[] passDatabase = {
        "programageneral_WUVJO73748"};

    protected static synchronized DataSource getDataSourceGeneral() {
        if (dataSource[0] == null) {
            BasicDataSource bds = new BasicDataSource();
            bds.setDriverClassName("org.postgresql.Driver");
            bds.setUrl("jdbc:postgresql://localhost:5432/" + userAndDatabase[0]);
            bds.setUsername(userAndDatabase[0]);
            bds.setPassword(passDatabase[0]);
            bds.setPoolPreparedStatements(true);
            bds.setMaxOpenPreparedStatements(5);
            dataSource[0] = bds;
        }
        return dataSource[0];
    }

}
