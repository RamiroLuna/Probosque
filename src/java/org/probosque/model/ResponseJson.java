/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.model;

/**
 *
 * @author Erick_G
 */
public class ResponseJson {
    
    private String message;
    private boolean sucessfull;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSucessfull() {
        return sucessfull;
    }

    public void setSucessfull(boolean sucessfull) {
        this.sucessfull = sucessfull;
    }
    
}
