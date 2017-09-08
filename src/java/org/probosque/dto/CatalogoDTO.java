/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author Erick_G
 */
public class CatalogoDTO implements Serializable {

    public CatalogoDTO() {
    }
    private Integer id;
    private String descripcion;
    private String value;
    private String text;
    private Boolean selected;
    private Integer region_municipio;
    private Integer id_municipio;
     
      public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Integer getRegion_municipio() {
        return region_municipio;
    }

    public void setRegion_municipio(Integer region_municipio) {
        this.region_municipio = region_municipio;
    }

    }
