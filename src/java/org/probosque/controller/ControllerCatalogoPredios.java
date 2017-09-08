package org.probosque.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.probosque.dao.CatalogoDAO;
import org.probosque.ejb.Catalogos;

import org.probosque.ejb.Folio;
import org.probosque.model.OutputJson;
import org.probosque.model.ResponseJson;
import org.probosque.validator.SQLValidator;

public  class ControllerCatalogoPredios extends CatalogoDAO {

    

    public OutputJson getCatalogoPredios(HttpServletRequest request) {
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        Folio folio= new Folio();
        Integer region = Integer.parseInt(request.getParameter("region"));
        Integer modulopredio_municipio = Integer.parseInt(request.getParameter("modulopredio_municipio"));
        Integer modulopredio_localidad = Integer.parseInt(request.getParameter("modulopredio_localidad"));
        Integer programa = Integer.parseInt(request.getParameter("programa"));
        try {
            
            String folioPredio = folio.getFolioPredio(15, region, modulopredio_municipio, modulopredio_localidad);
            output.setData(this.getCatalogoPredios(programa,folioPredio));
            response.setSucessfull(true);

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
