/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mike M
 */
public class CatalogosDTO implements Serializable {

    public CatalogosDTO() {
    }
    private String name_catalog;
    private List<CatalogoDTO>  catalogo;

    public String getName_catalog() {
        return name_catalog;
    }

    public void setName_catalog(String name_catalog) {
        this.name_catalog = name_catalog;
    }

    public List<CatalogoDTO> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<CatalogoDTO> catalogo) {
        this.catalogo = catalogo;
    }

      
}
