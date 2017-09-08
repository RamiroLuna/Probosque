package org.probosque.dto.interfaces;

import java.sql.SQLException;

public interface InsertRegistroInterface {

    String insertRegistro(Integer program, Object ogj)throws SQLException;
    
}
