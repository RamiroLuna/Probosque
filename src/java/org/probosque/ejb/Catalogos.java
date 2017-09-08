package org.probosque.ejb;
public class Catalogos {


public static String getQueryCatalogo(String catalogName)
  {
    StringBuilder sql= new StringBuilder();
    if (catalogName.equals("catalogos.municipio"))
       {
       sql.append(" SELECT VALUE, text, selected, region_municipio ");
       }
    else 
        if (catalogName.equals("catalogos.localidad"))
       {
       sql.append(" SELECT VALUE, text, selected, id_municipio ");
       }
     else 
        if (catalogName.equals("catalogos.predios"))
       {
       sql.append(" SELECT id_predio, text, selected ");
       }
    else 
       {
       sql.append(" SELECT VALUE, text, selected  ");
       }
    return sql.toString();
  
  }
    
}
