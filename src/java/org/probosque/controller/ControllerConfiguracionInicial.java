package org.probosque.controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.probosque.dao.CatalogoDAO;
import org.probosque.dto.CatalogosDTO;
import org.probosque.model.OutputJson;
import org.probosque.model.ResponseJson;
import org.probosque.validator.SQLValidator;

public class ControllerConfiguracionInicial extends CatalogoDAO {

    public OutputJson getCargaInicial(HttpServletRequest request) {
        Integer program = Integer.parseInt(request.getParameter("program"));
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        try {
            List<CatalogosDTO> cargaCatalogos = this.getCatalogosFormularios(program);
            if (cargaCatalogos != null || cargaCatalogos.size() > 0) {
                for (CatalogosDTO nameCatalog : cargaCatalogos) {
                    nameCatalog.setCatalogo(this.getCatalogo(program, nameCatalog.getName_catalog()));
                }
             output.setData(cargaCatalogos);
             response.setSucessfull(true);  
            } else {
                response.setMessage("No existen catalogos para programa");
            }            
        } catch (SQLException sqlEx) {
            response.setMessage(SQLValidator.getMessageError(sqlEx.getSQLState(), sqlEx.getMessage()));
            response.setSucessfull(false);
        } catch (Exception ex) {
            response.setSucessfull(false);
        }
        output.setResponse(response);
        return output;
    }
}
