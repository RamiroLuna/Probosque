package org.probosque.dto.interfaces;

import java.util.List;
import org.probosque.dto.CatalogoDTO;
import java.sql.SQLException;
public interface Catalogo {
 List<CatalogoDTO> getCatalogo(Integer Program,String nameCatalog)throws SQLException;    
}
