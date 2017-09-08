package org.probosque.dto.interfaces;

import java.sql.SQLException;

public interface DeleteRegistroInterface {
    Boolean deleteRegistro(Integer program, String Folio) throws SQLException;
}
