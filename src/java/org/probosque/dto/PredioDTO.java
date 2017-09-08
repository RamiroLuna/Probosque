/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.dto;

import java.io.Serializable;

/**
 *
 * @author Erick_G
 */
public class PredioDTO implements Serializable{
    
    String modulopredio_estado;
    String region;
    String id_region;
    String municipio;
    String id_municipio; 
    String localidad;
    String id_localidad;
    String folio;
    String cve_sedemex;
    String predio;
    String cve_tenencia;
    String id_tenencia;
    String llegada_predio; 
    String latitud;
    String longitud;
    String superficie_total;
    String superficie_cartografica;
    String superficie_arbolada;
    String superficie_otros;
    String cuenca;
    String cuenca_descripcion;
    String anp;
    String anp_descripcion;
    String estatus;
    String id_estatus;
    String observaciones; 
    String registroforestal_nacional;
    String permiso_aprovechamiento;
    String id_aprovechamiento;
    
    public PredioDTO() {
    }

    public String getModulopredio_estado() {
        return modulopredio_estado;
    }

    public void setModulopredio_estado(String modulopredio_estado) {
        this.modulopredio_estado = modulopredio_estado;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getId_region() {
        return id_region;
    }

    public void setId_region(String id_region) {
        this.id_region = id_region;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(String id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(String id_localidad) {
        this.id_localidad = id_localidad;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getCve_sedemex() {
        return cve_sedemex;
    }

    public void setCve_sedemex(String cve_sedemex) {
        this.cve_sedemex = cve_sedemex;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public String getCve_tenencia() {
        return cve_tenencia;
    }

    public void setCve_tenencia(String cve_tenencia) {
        this.cve_tenencia = cve_tenencia;
    }

    public String getId_tenencia() {
        return id_tenencia;
    }

    public void setId_tenencia(String id_tenencia) {
        this.id_tenencia = id_tenencia;
    }

    public String getLlegada_predio() {
        return llegada_predio;
    }

    public void setLlegada_predio(String llegada_predio) {
        this.llegada_predio = llegada_predio;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getSuperficie_total() {
        return superficie_total;
    }

    public void setSuperficie_total(String superficie_total) {
        this.superficie_total = superficie_total;
    }

    public String getSuperficie_cartografica() {
        return superficie_cartografica;
    }

    public void setSuperficie_cartografica(String superficie_cartografica) {
        this.superficie_cartografica = superficie_cartografica;
    }

    public String getSuperficie_arbolada() {
        return superficie_arbolada;
    }

    public void setSuperficie_arbolada(String superficie_arbolada) {
        this.superficie_arbolada = superficie_arbolada;
    }

    public String getSuperficie_otros() {
        return superficie_otros;
    }

    public void setSuperficie_otros(String superficie_otros) {
        this.superficie_otros = superficie_otros;
    }

    public String getCuenca() {
        return cuenca;
    }

    public void setCuenca(String cuenca) {
        this.cuenca = cuenca;
    }

    public String getCuenca_descripcion() {
        return cuenca_descripcion;
    }

    public void setCuenca_descripcion(String cuenca_descripcion) {
        this.cuenca_descripcion = cuenca_descripcion;
    }

    public String getAnp() {
        return anp;
    }

    public void setAnp(String anp) {
        this.anp = anp;
    }

    public String getAnp_descripcion() {
        return anp_descripcion;
    }

    public void setAnp_descripcion(String anp_descripcion) {
        this.anp_descripcion = anp_descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getId_estatus() {
        return id_estatus;
    }

    public void setId_estatus(String id_estatus) {
        this.id_estatus = id_estatus;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRegistroforestal_nacional() {
        return registroforestal_nacional;
    }

    public void setRegistroforestal_nacional(String registroforestal_nacional) {
        this.registroforestal_nacional = registroforestal_nacional;
    }

    public String getPermiso_aprovechamiento() {
        return permiso_aprovechamiento;
    }

    public void setPermiso_aprovechamiento(String permiso_aprovechamiento) {
        this.permiso_aprovechamiento = permiso_aprovechamiento;
    }

    public String getId_aprovechamiento() {
        return id_aprovechamiento;
    }

    public void setId_aprovechamiento(String id_aprovechamiento) {
        this.id_aprovechamiento = id_aprovechamiento;
    }
    
}
