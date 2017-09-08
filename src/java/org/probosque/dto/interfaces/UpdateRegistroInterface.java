package org.probosque.dto.interfaces;

import java.sql.SQLException;

public interface UpdateRegistroInterface {
    Boolean updateRegistro(Integer program, Object obj)throws SQLException;
}
