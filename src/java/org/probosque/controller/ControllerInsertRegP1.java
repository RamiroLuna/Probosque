package org.probosque.controller;

import com.google.gson.Gson;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.probosque.dao.RegistroDAO;
import org.probosque.dto.FichaPrincipalP8DTO;
import org.probosque.model.OutputJson;
import org.probosque.model.ResponseJson;
import org.probosque.validator.Messages;
import org.probosque.validator.SQLValidator;

public class ControllerInsertRegP1 extends RegistroDAO{
 
    public OutputJson insert(HttpServletRequest request)
     {
      Integer program = Integer.parseInt(request.getParameter("program"));
      String Registro= request.getParameter("formulario");
      Gson gson = new Gson();
      FichaPrincipalP8DTO fichaDatos=gson.fromJson(Registro, FichaPrincipalP8DTO.class);      
      OutputJson output = new OutputJson();
      ResponseJson response = new ResponseJson();
        try {
             output.setData(this.insertRegistro(program,fichaDatos.getRegistro().get(0)));
             response.setMessage(Messages.MESSAGE_INSERT);
             response.setSucessfull(true);                       
        } catch (SQLException sqlEx) {
            response.setMessage(SQLValidator.getMessageError(sqlEx.getSQLState(), sqlEx.getMessage()));
            response.setSucessfull(false);
        } catch (Exception ex) {
            response.setSucessfull(false);
            response.setMessage(ex.getMessage());
        }
        output.setResponse(response);
        return output;
     }
}
