package org.probosque.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.probosque.database.interfaces.DataBaseProgram;
import org.probosque.dto.CatalogoDTO;
import org.probosque.dto.CatalogosDTO;
import org.probosque.dto.interfaces.Catalogo;
import org.probosque.dto.interfaces.CatalogosFormularios;
import org.probosque.ejb.Catalogos;

public class CatalogoDAO extends DataBaseProgram implements Catalogo, CatalogosFormularios{
    @Override
    public List<CatalogoDTO> getCatalogo(Integer program, String nameCatalog) throws SQLException {
      StringBuilder sql = new StringBuilder();
      sql.append(Catalogos.getQueryCatalogo(nameCatalog));
      sql.append(" FROM CATALOGOS.SP_getCatalogo(?)");
      Object[] params = {nameCatalog};
      ResultSetHandler rsh = new BeanListHandler(CatalogoDTO.class);                
       List<CatalogoDTO>catalogo=(List<CatalogoDTO>) this.getDataBaseProgram(program).query(sql.toString(), rsh,params);
       return catalogo;
    }

    @Override
    public List<CatalogosDTO> getCatalogosFormularios(Integer program) throws SQLException {
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT sp_getcatalogs AS name_catalog ");
      sql.append(" FROM CATALOGOS.SP_getCatalogs()");
      ResultSetHandler rsh = new BeanListHandler(CatalogosDTO.class);                
      List<CatalogosDTO>catalogo=(List<CatalogosDTO>) this.getDataBaseProgram(program).query(sql.toString(), rsh);
      return catalogo;
    }
    
    public List<CatalogoDTO> getCatalogoPredios(Integer program, String folio) throws SQLException {
      StringBuilder sql = new StringBuilder();
      sql.append(Catalogos.getQueryCatalogo("catalogos.predios"));
      sql.append(" FROM CATALOGOS.SP_getCatalogo(?,?)");
      Object[] params = {"catalogos.predios",folio};
      ResultSetHandler rsh = new BeanListHandler(CatalogoDTO.class);                
       List<CatalogoDTO>catalogo=(List<CatalogoDTO>) this.getDataBaseProgram(program).query(sql.toString(), rsh,params);
       return catalogo;
    }
    
}
