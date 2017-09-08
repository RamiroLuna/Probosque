package org.probosque.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class FormularioPrincipalDTO implements Serializable {

    public FormularioPrincipalDTO() {
        super();
    }
    @SerializedName("formulario")    
    public List<FormularioPrincipalDTO> campos;

    public List<FormularioPrincipalDTO> getCampos() {
        return campos;
    }

    public void setCampos(List<FormularioPrincipalDTO> campos) {
        this.campos = campos;
    }
    private String region;
    private String municipio;
    private String localidad;
    private String claveUnicaIdentificacion;
    private String sedemex;
    private String nombrePredio;
    private String tipoTenenciaTierra;
    private String descripcionComoLlegarPredio;
    private String latitud;
    private String longitud;
    private String superficieTotal;
    private String superficieCartografica;
    private String superficieArbolada;
    private String superficieOtrosUsos;
    private String cuencaEspecifica;
    private String areaNaturalProtegida;
    private String estatusPredio;
    private String observacionesPredio;
    private String registroForestalNacional;
    private String permisoAprovechamientoForestal;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getClaveUnicaIdentificacion() {
        return claveUnicaIdentificacion;
    }

    public void setClaveUnicaIdentificacion(String claveUnicaIdentificacion) {
        this.claveUnicaIdentificacion = claveUnicaIdentificacion;
    }

    public String getSedemex() {
        return sedemex;
    }

    public void setSedemex(String sedemex) {
        this.sedemex = sedemex;
    }

    public String getNombrePredio() {
        return nombrePredio;
    }

    public void setNombrePredio(String nombrePredio) {
        this.nombrePredio = nombrePredio;
    }

    public String getTipoTenenciaTierra() {
        return tipoTenenciaTierra;
    }

    public void setTipoTenenciaTierra(String tipoTenenciaTierra) {
        this.tipoTenenciaTierra = tipoTenenciaTierra;
    }

    public String getDescripcionComoLlegarPredio() {
        return descripcionComoLlegarPredio;
    }

    public void setDescripcionComoLlegarPredio(String descripcionComoLlegarPredio) {
        this.descripcionComoLlegarPredio = descripcionComoLlegarPredio;
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

    public String getSuperficieTotal() {
        return superficieTotal;
    }

    public void setSuperficieTotal(String superficieTotal) {
        this.superficieTotal = superficieTotal;
    }

    public String getSuperficieCartografica() {
        return superficieCartografica;
    }

    public void setSuperficieCartografica(String superficieCartografica) {
        this.superficieCartografica = superficieCartografica;
    }

    public String getSuperficieArbolada() {
        return superficieArbolada;
    }

    public void setSuperficieArbolada(String superficieArbolada) {
        this.superficieArbolada = superficieArbolada;
    }

    public String getSuperficieOtrosUsos() {
        return superficieOtrosUsos;
    }

    public void setSuperficieOtrosUsos(String superficieOtrosUsos) {
        this.superficieOtrosUsos = superficieOtrosUsos;
    }

    public String getCuencaEspecifica() {
        return cuencaEspecifica;
    }

    public void setCuencaEspecifica(String cuencaEspecifica) {
        this.cuencaEspecifica = cuencaEspecifica;
    }

    public String getAreaNaturalProtegida() {
        return areaNaturalProtegida;
    }

    public void setAreaNaturalProtegida(String areaNaturalProtegida) {
        this.areaNaturalProtegida = areaNaturalProtegida;
    }

    public String getEstatusPredio() {
        return estatusPredio;
    }

    public void setEstatusPredio(String estatusPredio) {
        this.estatusPredio = estatusPredio;
    }

    public String getObservacionesPredio() {
        return observacionesPredio;
    }

    public void setObservacionesPredio(String observacionesPredio) {
        this.observacionesPredio = observacionesPredio;
    }

    public String getRegistroForestalNacional() {
        return registroForestalNacional;
    }

    public void setRegistroForestalNacional(String registroForestalNacional) {
        this.registroForestalNacional = registroForestalNacional;
    }

    public String getPermisoAprovechamientoForestal() {
        return permisoAprovechamientoForestal;
    }

    public void setPermisoAprovechamientoForestal(String permisoAprovechamientoForestal) {
        this.permisoAprovechamientoForestal = permisoAprovechamientoForestal;
    }

    
    
}
