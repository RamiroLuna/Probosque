package org.probosque.database.interfaces;

import org.apache.commons.dbutils.QueryRunner;


public interface PoolDataSource {
    QueryRunner getDataBaseProgram(Integer program);
}
