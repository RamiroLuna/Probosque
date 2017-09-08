/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.dao;

import java.sql.SQLException;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.probosque.dto.FichaPrincipalP8DTO;
import org.probosque.dto.ResultString;
import org.probosque.dto.interfaces.Registro;

/**
 *
 * @author Mike M
 */
public class RegistroDAO extends Registro {

    @Override
    public String insertRegistro(Integer program,Object obj) throws SQLException {
        FichaPrincipalP8DTO registro= (FichaPrincipalP8DTO) obj;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT result from sp_insertPrincipal (15,").append(Integer.parseInt(registro.getRegion())).append(", ")
                             .append(Integer.parseInt(registro.getTipo_accion())).append(", ")
                             .append(Integer.parseInt(registro.getModulopredio_municipio())).append(", ")
                             .append(Integer.parseInt(registro.getModulopredio_localidad())).append(", ")
                             .append(Integer.parseInt(registro.getAnio())).append(", ")
                             .append(registro.getModulopredio_cup()).append(", ")
                             .append(registro.getRazon_social()).append(", ")
                             .append(registro.getParaje()).append(", ")
                             .append(registro.getCoordenadas_utm_x()).append(", ")
                .append(registro.getCoordenadas_utm_y()).append(", ")
                .append(registro.getMetros_sobre_nivel_mar()).append(", ")
                .append(registro.getFecha_inicio()).append(", ")
                .append(registro.getFecha_termino()).append(", ")
                .append(registro.getZona_critica()).append(", ")
                .append(registro.getTotal_participantes()).append(", ")
                .append(registro.getVehiculos_sin_irregularidades()).append(", ")
                .append(registro.getVehiculos_revisados()).append(", ")
                .append(Integer.parseInt(registro.getTotal_personas())).append(", ")
                .append(registro.getNumero_orden()).append(", ")
                .append(registro.getTipo_documento()).append(", ")
                .append(registro.getNum_documento()).append(", ")
                .append(registro.getDependencia_expide_documento()).append(", ")
                .append(registro.getAgencia_ministerio_solicita_dictamen()).append(", ")
                .append(registro.getMedidas_seguridad()).append(", ")
                .append(registro.getValor_comercial()).append(", ")
                .append(registro.getImpacto_ambiental()).append(", ")
                .append(registro.getReparacion_danio()).append(", ")
                .append(registro.getTotal_dictamen()).append(", ")
                .append(registro.getObservaciones()).append(", ")
                .append(registro.getCodigo_identificacion()).append(", ")
                .append(registro.getRegistro_forestal_nacional()).append(", ")
                .append(registro.getEstatus_industria()).append(") ");
        ResultSetHandler rsh = new BeanHandler(ResultString.class);
       ResultString result = (ResultString) this.getDataBaseProgram(program).query(sql.toString(), rsh);
       return result.getResult();
    }

    

    @Override
    public Object selectRegistro(Integer program,String folio) throws SQLException{
        StringBuilder sql= new StringBuilder("Select * from spGetPrincipal(?)");
        Object[] params = {folio};
        ResultSetHandler rsh = new BeanHandler(FichaPrincipalP8DTO.class);
        FichaPrincipalP8DTO result = (FichaPrincipalP8DTO) this.getDataBaseProgram(program).query(sql.toString(), params, rsh);
        return result;
    }

    @Override
    public Boolean updateRegistro(Integer program,Object obj) throws SQLException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
