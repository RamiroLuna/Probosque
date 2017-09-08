package org.probosque.controller;

import com.google.gson.Gson;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.probosque.dao.FormularioPrincipalDAO;
import org.probosque.dao.MultiregistroDAO;
import org.probosque.dto.FormularioPrincipalDTO;
import org.probosque.dto.ResultInteger;
import org.probosque.ejb.Archivos;
import org.probosque.model.Consecutivos;
import org.probosque.model.OutputJson;
import org.probosque.model.ResponseJson;
import org.probosque.validator.FormularioPrincipalValidator;
import org.probosque.validator.Messages;
import org.probosque.validator.SQLValidator;

public class ControllerPredios {

    public OutputJson getPredio(HttpServletRequest request) throws Exception {

        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        FormularioPrincipalDAO dao = new FormularioPrincipalDAO();

        try {
            String clavePredio = request.getParameter("clavePredio");
            output.setData(dao.getPredio(clavePredio));
            response.setSucessfull(true);
            response.setMessage("Correcto");
        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);
        }catch (IndexOutOfBoundsException ex){
            response.setSucessfull(false);
            response.setMessage(Messages.MESSAGE_ERROR_INDICES);
        }
        catch (Exception ex){
            response.setSucessfull(false);
            response.setMessage(Messages.MESSAGE_ERROR_INESPERADO + ex.getMessage());
        }
        output.setResponse(response);
        return output;
    }

    public OutputJson insertPredio(HttpServletRequest request) {
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        Gson gson = new Gson();
        try {
            String _json = request.getParameter("formularioPrincipal");
            FormularioPrincipalDTO dto = gson.fromJson(_json.trim(), FormularioPrincipalDTO.class);

            FormularioPrincipalDAO dao = new FormularioPrincipalDAO();
            FormularioPrincipalValidator validatorP = new FormularioPrincipalValidator();
            output.setData(dao.InsertFormularioPrincipal(validatorP.getFormularioPrincipalDTO(dto.getCampos().get(0))));
            StringBuilder message = new StringBuilder();
            message.append("Registro exitoso \n se asigno la clave de predio ").append(output.getData()).
                    append(" al predio ").append(dto.getCampos().get(0).getNombrePredio());
            response.setSucessfull(true);
            response.setMessage(message.toString());
        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);
        } catch (Exception ex) {
            response.setSucessfull(false);
            response.setMessage(Messages.MESSAGE_ERROR_INESPERADO + ex.getMessage());
        }
        output.setResponse(response);
        return output;
    }

    public OutputJson updatePredio(HttpServletRequest request) {
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        Gson gson = new Gson();
        try {
            String _json = request.getParameter("formularioPrincipal");
            FormularioPrincipalDTO dto = gson.fromJson(_json.trim(), FormularioPrincipalDTO.class);
            FormularioPrincipalValidator validatorP = new FormularioPrincipalValidator();
            FormularioPrincipalDAO dao = new FormularioPrincipalDAO();
            dao.updateFormularioPrincipal(validatorP.getFormularioPrincipalDTO(dto.getCampos().get(0)));
            response.setSucessfull(true);
            response.setMessage(Messages.MESSAGE_INSERT);

        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);
        } catch (Exception ex) {
            response.setSucessfull(false);
            response.setMessage(Messages.MESSAGE_ERROR_INESPERADO + ex.getMessage());
        }
        output.setResponse(response);
        return output;
    }

    public OutputJson deletePredio(HttpServletRequest request) {
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        try {
            String folio = request.getParameter("claveUnicaIdentificacion");
            MultiregistroDAO mDAO = new MultiregistroDAO();
            Consecutivos consec = new Consecutivos();
            Archivos arch = new Archivos();
            consec = arch.getListaConsecutivos(folio);
            FormularioPrincipalDAO dao = new FormularioPrincipalDAO();
            dao.deleteFormularioPrincipal(folio);
            if (consec.getSuccessfull() == Boolean.TRUE) {
                for (ResultInteger c : consec.getConsecutivo()) {
                    String pathArchivo = arch.getPathArchive(folio, 0, c.getResult());
                    arch.borrarArchivo(pathArchivo);
                   }
            }

            response.setSucessfull(true);
            response.setMessage(Messages.MESSAGE_DELETE);
        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);
        } catch (Exception ex) {
            response.setSucessfull(false);
            response.setMessage(Messages.MESSAGE_ERROR_INESPERADO + ex.getMessage());
        }
        output.setResponse(response);
        return output;
    }
}
