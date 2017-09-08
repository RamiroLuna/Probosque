package org.probosque.dto.interfaces;

import java.sql.SQLException;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.probosque.database.interfaces.DataBaseProgram;
import org.probosque.dto.ResultBoolean;

public abstract class Registro extends DataBaseProgram implements InsertRegistroInterface,
        DeleteRegistroInterface,  SelectRegistroInterface, UpdateRegistroInterface{
   
   
    @Override
    public String insertRegistro(Integer program, Object ogj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deleteRegistro(Integer program, String Folio) throws SQLException {
        String sql= "Select result from spDeletePrincipal(?)";
        Object[] params = {Folio};
        ResultSetHandler rsh = new BeanHandler(ResultBoolean.class);
        ResultBoolean result = (ResultBoolean) this.getDataBaseProgram(program).query(sql, params, rsh);
        return result.getResult();
    }
    
    @Override
     public Object selectRegistro(Integer program, String folio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean updateRegistro(Integer program, Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
