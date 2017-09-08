package org.probosque.controller;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.probosque.dao.MultiregistroDAO;
import org.probosque.dto.MultiImagenesDTO;
import org.probosque.dto.PoligonoDTO;
import org.probosque.dto.RepresentanteDTO;
import org.probosque.ejb.Archivos;
import org.probosque.model.OutputJson;
import org.probosque.model.ResponseJson;
import org.probosque.validator.FormularioPoligonosValidator;
import org.probosque.validator.Messages;
import org.probosque.validator.SQLValidator;

/**
 *
 * @author Erick_G
 */
public class ControllerMultiregistros {

    /**
     * ************************* INICIO ABC PARA MULTIREGISTROS POLIGONOS
     * ****************************
     */
    public OutputJson insertMultiregistroPoligono(HttpServletRequest request) {

        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        Gson gson = new Gson();

        try {
            String poligono = request.getParameter("poligono");
            poligono = poligono.replaceAll("\"consecutivo\":\"\"", "\"consecutivo\":\"0\"");
            PoligonoDTO dto = gson.fromJson(poligono.trim(), PoligonoDTO.class);

            MultiregistroDAO dao = new MultiregistroDAO();
            FormularioPoligonosValidator validatorPoli = new FormularioPoligonosValidator();
            output.setData(dao.insertMultiregistroPoligono(validatorPoli.getMultiPoligonoDTO(dto.getLista().get(0))));
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

    public OutputJson updateMultiregistroPoligono(HttpServletRequest request) throws SQLException, Exception {

        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        Gson gson = new Gson();

        try {
            String poligono = request.getParameter("poligono");
            MultiregistroDAO dao = new MultiregistroDAO();
            PoligonoDTO dto = gson.fromJson(poligono.trim(), PoligonoDTO.class);
            FormularioPoligonosValidator validatorPoli = new FormularioPoligonosValidator();
            output.setData(dao.updateMultiregistroPoligono(validatorPoli.getMultiPoligonoDTO(dto.getLista().get(0))));
            response.setSucessfull(true);
            response.setMessage(Messages.MESSAGE_UPDATE);
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

    /**
     * ************************* INICIO ABC PARA MULTIREGISTROS REPRESENTANTES
     * ****************************
     */
    public OutputJson insertMultiregistroRepresentante(HttpServletRequest request) throws SQLException, Exception {

        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        MultiregistroDAO dao = new MultiregistroDAO();
        ControllerMultiregistros controller = new ControllerMultiregistros();

        Gson gson = new Gson();

        try {
            String representante = request.getParameter("representante");
            representante = representante.replaceAll("\"consecutivo\":\"\"", "\"consecutivo\":\"0\"");
            RepresentanteDTO dto = gson.fromJson(representante.trim(), RepresentanteDTO.class);
            output.setData(dao.insertMultiregistroRepresentante(dto.getLista().get(0)));
            response.setMessage(Messages.MESSAGE_INSERT);
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

    public OutputJson updateMultiregistroRepresentante(HttpServletRequest request) throws SQLException, Exception {

        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        MultiregistroDAO dao = new MultiregistroDAO();

        Gson gson = new Gson();

        try {
            String representante = request.getParameter("representante");
            RepresentanteDTO dto = gson.fromJson(representante.trim(), RepresentanteDTO.class);
            output.setData(dao.updateMultiregistroRepresentante(dto.getLista().get(0)));
            response.setMessage(Messages.MESSAGE_UPDATE);
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

    public OutputJson deleteMultiregistro(HttpServletRequest request) {
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        Gson gson = new Gson();
        try {
            String folio = request.getParameter("folio");
            String table_name = request.getParameter("table_name");
            Integer consecutivo = Integer.parseInt(request.getParameter("consecutivo"));
            MultiregistroDAO dao = new MultiregistroDAO();
            dao.deleteMultiregistro(table_name, folio, consecutivo);
            if (table_name.equals("formularios.imagen")) {
                Archivos arch = new Archivos();
                String pathArchivo = arch.getPathArchive(folio, 0, consecutivo);
                arch.borrarArchivo(pathArchivo);
            }
            response.setSucessfull(true);
            response.setMessage(Messages.MESSAGE_DELETE);
        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);
        } catch (Exception ex) {
            response.setMessage(Messages.MESSAGE_ERROR_INESPERADO + ex.getMessage());
            response.setSucessfull(false);
        }
        output.setResponse(response);
        return output;
    }

    public OutputJson getRepresentantes(HttpServletRequest request) {
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        try {
            String folio = request.getParameter("folio");
            MultiregistroDAO dao = new MultiregistroDAO();
            output.setData(dao.getRepresentantes(folio));
            response.setSucessfull(true);
            response.setMessage("REGISTRO EXITOSO");
        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);
        } catch (NullPointerException exNP) {
            response.setSucessfull(true);
            response.setMessage(" NO EXISTEN REGISTROS DE REPRESENTANTES ");
        } catch (Exception ex) {
            response.setSucessfull(false);
            response.setMessage(Messages.MESSAGE_ERROR_INESPERADO + ex.getMessage());
        }
        output.setResponse(response);
        return output;

    }

    public OutputJson getPoligonos(HttpServletRequest request) {
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        try {
            String folio = request.getParameter("folio");
            MultiregistroDAO dao = new MultiregistroDAO();
            output.setData(dao.getPoligonos(folio));
            response.setSucessfull(true);
            response.setMessage(" REGISTRO EXITOSO ");
        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);

        } catch (NullPointerException exNP) {
            response.setSucessfull(true);
            response.setMessage(" No existen datos de poligonos ");
        } catch (Exception ex) {
            response.setSucessfull(false);
            response.setMessage(Messages.MESSAGE_ERROR_INESPERADO + ex.getMessage());

        }
        output.setResponse(response);
        return output;

    }

    public OutputJson getImagenes(HttpServletRequest request) {
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        try {
            String folio = request.getParameter("folio");
            MultiregistroDAO dao = new MultiregistroDAO();
            List<MultiImagenesDTO> imagenes = (List<MultiImagenesDTO>) dao.getImagenes(folio);
            Archivos arch = new Archivos();
            for (MultiImagenesDTO registro : imagenes) {
                String consecutivo = arch.getConsecutivo(registro.getConsecutivo());
                registro.setNombre_archivo(registro.getFolio() + "_url_" + consecutivo);
            }
            output.setData(imagenes);
            response.setSucessfull(true);
            response.setMessage(" REGISTRO EXITOSO ");
        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);
        } catch (NullPointerException exNP) {
            response.setSucessfull(true);
            response.setMessage(" No existen registros de multiregistro de archivos ");
        } catch (Exception ex) {
            response.setSucessfull(false);
            response.setMessage(Messages.MESSAGE_ERROR_INESPERADO);
        }
        output.setResponse(response);
        return output;
    }

    public OutputJson insertMultiregistroImagen(HttpServletRequest request) throws SQLException, Exception {

        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        MultiregistroDAO dao = new MultiregistroDAO();

        Gson gson = new Gson();

        try {
            String folio = request.getParameter("folio");
            String fecha = request.getParameter("fecha");
            String descripcion = IOUtils.toString(request.getPart("descripcion").getInputStream(), "UTF-8");
            String campoAsociado = request.getParameter("campoAsociado");
            Part file = request.getPart("file");

            MultiImagenesDTO dto = new MultiImagenesDTO(folio, fecha, descripcion, campoAsociado, file.getSubmittedFileName());

            Integer consecutivo = dao.insertMultiregistroImagen(dto);
            Archivos arch = new Archivos();
            String nombreArchivo = arch.uploadFile(file, dto.getFolio(),
                    arch.getConsecutivo(consecutivo), 0, file.getSubmittedFileName());
            dto = dao.getRegImagen(folio, consecutivo);
            dto.setNombre_archivo(nombreArchivo);
            response.setSucessfull(true);
            response.setMessage(Messages.MESSAGE_INSERT);
            output.setData(dto);
        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);
        } catch (Exception ex) {
            response.setSucessfull(false);
            response.setMessage(Messages.MESSAGE_ERROR_INESPERADO + ex.getMessage());
        } finally {
            output.setResponse(response);
        }
        return output;

    }

    public OutputJson getAuditorias(HttpServletRequest request) {
        OutputJson output = new OutputJson();
        ResponseJson response = new ResponseJson();
        MultiregistroDAO dao = new MultiregistroDAO();

        Gson gson = new Gson();
        try {
            String folio = request.getParameter("folio");
            output.setData(dao.getAudotoriasPredio(folio));
            response.setSucessfull(true);
            response.setMessage("Registros");

        } catch (SQLException sqlError) {
            SQLValidator sqlV = new SQLValidator();
            response.setMessage(sqlV.getMessageError(sqlError.getSQLState(), sqlError.getMessage()));
            response.setSucessfull(false);
        } catch (Exception ex) {
            response.setSucessfull(false);
            response.setMessage(ex.getMessage());
        } finally {
            output.setResponse(response);
        }
        return output;

    }

}
