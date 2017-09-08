package org.probosque.dto.interfaces;

import java.sql.SQLException;

public interface SelectRegistroInterface {

Object selectRegistro(Integer program,String folio)
        throws SQLException;    
}
