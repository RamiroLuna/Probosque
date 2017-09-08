/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.dao;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.probosque.dto.CatalogoDTO;
import org.probosque.dto.CatalogosDTO;
import org.probosque.ejb.Catalogos;

/**
 *
 * @author Mike M
 */
public class CatalogosDAO {

    public List<CatalogosDTO> getCatalogosFormulario(String tableName)
            throws SQLException {
        DataSource ds = PoolDataSource.getDataSourceGeneral();
        QueryRunner qr = new QueryRunner(ds);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT sp_getcatalogforms as name_catalog from CATALOGOS.sp_getcatalogforms(?)");
        Object[] params = {tableName};
        ResultSetHandler rsh = new BeanListHandler(CatalogosDTO.class);
        List<CatalogosDTO> catalogosFormulario = (List<CatalogosDTO>) qr.query(sql.toString(), rsh, params);
        return catalogosFormulario;
    }

    public List<CatalogoDTO> getCatalogo(String tableName)
            throws SQLException {
        DataSource ds = PoolDataSource.getDataSourceGeneral();
        QueryRunner qr = new QueryRunner(ds);
        StringBuilder sql = new StringBuilder();
        sql.append(Catalogos.getQueryCatalogo(tableName));
        sql.append(" FROM CATALOGOS.SP_getCatalogo(?)");
        Object[] params = {tableName};
        ResultSetHandler rsh = new BeanListHandler(CatalogoDTO.class);
        List<CatalogoDTO> catalogo = (List<CatalogoDTO>) qr.query(sql.toString(), rsh, params);
        return catalogo;
    }
}
