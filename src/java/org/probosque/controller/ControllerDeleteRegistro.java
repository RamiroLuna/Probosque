
package org.probosque.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.probosque.dto.interfaces.Registro;
import org.probosque.model.OutputJson;
import org.probosque.model.ResponseJson;
import org.probosque.validator.Messages;
import org.probosque.validator.SQLValidator;
public class ControllerDeleteRegistro extends Registro{

    public OutputJson deleteRegistroPrincipal(HttpServletRequest request)
      {
       OutputJson output = new OutputJson();
       ResponseJson response= new ResponseJson();
       Integer program = Integer.parseInt(request.getParameter("program"));
       String folio = request.getParameter("folio");
         try {
             output.setData(this.deleteRegistro(program, folio));
             response.setMessage(Messages.MESSAGE_DELETE);
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
