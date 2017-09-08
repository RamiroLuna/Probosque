/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.probosque.dao.CatalogosDAO;
import org.probosque.dto.CatalogoDTO;
import org.probosque.dto.CatalogosDTO;
import org.probosque.model.OutputJson;
import org.probosque.model.ResponseJson;
import org.probosque.validator.Messages;
import org.probosque.validator.SQLValidator;

/**
 *
 * @author Erick_G
 */
public class ControllerCargaInicial {

    public OutputJson getCatalogos(HttpServletRequest request) throws Exception {

        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        CatalogosDAO dao = new CatalogosDAO();
        try {
            String tableName = request.getParameter("tableName");
            List<CatalogosDTO> catalogos = (List<CatalogosDTO>) dao.getCatalogosFormulario(tableName);
            if (catalogos != null) {
                for (CatalogosDTO cat : catalogos) {
                    List<CatalogoDTO> catalogo = (List<CatalogoDTO>) dao.getCatalogo(cat.getName_catalog());
                    cat.setCatalogo(catalogo);
                }
            }
            output.setData(catalogos);
            response.setSucessfull(true);
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
