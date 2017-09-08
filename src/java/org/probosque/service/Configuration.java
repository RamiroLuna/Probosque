/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.service;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick_G
 */
public class Configuration {
    
    public static void setHeadersJson(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Allow", "GET, HEAD, POST, TRACE, OPTIONS");
        response.setContentType("application/json;charset=UTF-8");
    }
  public static void setHeadersFile(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Allow", "GET, HEAD, POST, TRACE, OPTIONS");
    }
        
}
