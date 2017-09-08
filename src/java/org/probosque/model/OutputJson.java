/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.model;

import java.util.List;


/**
 *
 * @author Erick_G
 */
public class OutputJson {
    
    private Object response;
    private Object data;
    private Object data1;
    private List<LabelValue> tabular;
    private String cadena;    

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<LabelValue> getTabular() {
        return tabular;
    }

    public void setTabular(List<LabelValue> tabular) {
        this.tabular = tabular;
    }

    public Object getData1() {
        return data1;
    }
    
    public void setData1(Object data, Object data1) {
        this.data = data;
        this.data1 = data1;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
}
