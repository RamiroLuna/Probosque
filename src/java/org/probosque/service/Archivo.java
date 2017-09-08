package org.probosque.service;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.probosque.dao.PATH;

@WebServlet(name = "Archivo", urlPatterns = {"/Archivo"})
public class Archivo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Configuration.setHeadersFile(response);
            try  {
            String  action = request.getParameter("action");
                    
            int programa=0;
            switch (action) {
                case "get":
                    String gField = request.getParameter("nombre_archivo");
                    File nfsPDF = new File(PATH.PATH_IMAGENES+programa+"\\QR\\"+gField+".pdf");                 
                    //Si el Field es PDF ... 
                    if (nfsPDF.exists()) {
                        
                        FileInputStream fis = new FileInputStream(nfsPDF);
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        ServletOutputStream sos = response.getOutputStream();
                        byte[] buffer = new byte[2048];
                        while (true) {
                          int bytesRead = bis.read(buffer, 0, buffer.length);
                          if (bytesRead < 0) {
                            break;
                          }
                        sos.write(buffer, 0, bytesRead);
                        sos.flush();
                        }
                        sos.flush();
                        bis.close();

                    }else{
                        String ext = "png";
                        response.setContentType("image/" + ext);
                        File file = new File(PATH.PATH_IMAGENES+programa+"\\QR\\"+gField);                 
                        if (file.exists()) {
                            BufferedImage bi = ImageIO.read(file);
                            OutputStream out = response.getOutputStream();
                            ImageIO.write(bi, ext, out);
                            out.close();
                        }
                    }
                    break;
                
            }
        } catch (Exception ex) {
            response.getWriter().print(ex.getMessage());
            //Logger.etLogger(QR.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
