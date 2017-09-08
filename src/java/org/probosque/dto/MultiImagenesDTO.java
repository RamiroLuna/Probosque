package org.probosque.dto;

import java.io.Serializable;

public class MultiImagenesDTO  implements Serializable {

    public MultiImagenesDTO() {
    }
    
  private Integer consecutivo;
  private String  folio;
  private String  url;
  private String  fecha;
  private String descripcion;
  private String  descripcion_campo;
  private String id_campoasociado;
  private String nombre_archivo;

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion_campo() {
        return descripcion_campo;
    }

    public void setDescripcion_campo(String descripcion_campo) {
        this.descripcion_campo = descripcion_campo;
    }

    public String getId_campoasociado() {
        return id_campoasociado;
    }

    public void setId_campoasociado(String id_campoasociado) {
        this.id_campoasociado = id_campoasociado;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public MultiImagenesDTO(String folio, String fecha, String descripcion, String id_campoasociado, String url) {
        this.folio = folio;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.id_campoasociado = id_campoasociado;
        this.url = url;
    }

    
}
