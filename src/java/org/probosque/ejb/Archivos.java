package org.probosque.ejb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import org.probosque.dao.MultiregistroDAO;
import org.probosque.dao.PATH;
import org.probosque.model.Consecutivos;
import org.probosque.model.OutputJson;
import javax.servlet.http.Part;

public class Archivos {
public String uploadFile(Part file,String folio, String consecutivo, Integer program, String nombreArchivo) throws Exception {
         String _subField = nombreArchivo.substring(nombreArchivo.length()-3,nombreArchivo.length());
         String _archivo="pdf";
         String nombreArchivoFinal="";
         File folder = new File(PATH.PATH_IMAGENES+program+"\\qr\\");
                    if (!folder.exists()) {
                        folder.mkdirs();
                    }
                    
                    String sFichero = "";
                    if (_archivo.equalsIgnoreCase(_subField)) {
                        sFichero = "C:\\sifem\\programa"+program+"\\qr\\" + folio + "_url_" +consecutivo+".pdf";
                        File fichero = new File(sFichero);
                        nombreArchivoFinal=folio + "_url_" +consecutivo+".pdf";
                        if (fichero.exists()) {
                            fichero.delete();
                        }
                    } else {
                        sFichero = "C:\\sifem\\programa"+program+"\\qr\\" + folio + "_url_" + consecutivo;
                        nombreArchivoFinal=folio + "_url_" +consecutivo;
                        File fichero = new File(sFichero);
                        if (fichero.exists()) {
                            fichero.delete();
                        }
                    }

                    OutputStream outFile = null;
                    InputStream filecontent = null;
                    try {
                        outFile =new FileOutputStream(new File(sFichero));
                        //outFile = new FileOutputStream(new File("C:\\sifem\\programa"+programa+"\\qr\\" + _folio + "_" + _field + "_" + _consecutivo));
                        filecontent = file.getInputStream();
                        int read = 0;
                        final byte[] bytes = new byte[1024];
                        while ((read = filecontent.read(bytes)) != -1) {
                            outFile.write(bytes, 0, read);
                        }
                    } catch (FileNotFoundException fne) {

                    } finally {
                        if (outFile != null) {
                            outFile.close();
                        }
                        if (filecontent != null) {
                            filecontent.close();
                        }
                    }    
                    nombreArchivoFinal=nombreArchivoFinal.replaceAll(".pdf","");
                   return nombreArchivoFinal; 
 }            


public void borrarArchivo(String url )
     {   
      File archivo = new File(url);
      if(archivo.exists())
           {
            archivo.delete();
           }
      else{
          archivo = new File(url+".pdf");
          if(archivo.exists())
           {
            archivo.delete();
           }
          }
     }

   
    public String getPathArchive(String folio,Integer programa, Integer consecutivo)
    {
    StringBuilder path= new StringBuilder();
    path.append(PATH.PATH_IMAGENES).append(String.valueOf(programa)).
         append("\\qr\\").append(folio).append("_url_").append(getConsecutivo(consecutivo));   
    return path.toString();
    }
    
    public String getConsecutivo(Integer consecutivo)
    {
       StringBuilder numero= new StringBuilder();
     if(consecutivo < 10)
        {  
         numero.append("00").append(String.valueOf(consecutivo));
        }
     else 
         if(consecutivo >= 10 && consecutivo < 100)
            {
             numero.append("00").append(String.valueOf(consecutivo));   
            }
         else
            {
             numero.append(String.valueOf(consecutivo));   
            }
     return numero.toString();
    }
  public Consecutivos getListaConsecutivos(String folio) throws SQLException
     {
     Consecutivos con= new Consecutivos();    
     MultiregistroDAO dao = new MultiregistroDAO();
     try{
          con.setConsecutivo(dao.getConsecutivosImagenes(folio));
          con.setSuccessfull(Boolean.TRUE);
        }
     catch(NullPointerException ex)
         {
             con.setSuccessfull(Boolean.FALSE);
         }
     return con;    
     }  
    
}
