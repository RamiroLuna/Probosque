package org.probosque.dto;

import java.io.Serializable;

public class AuditoriaDTO implements Serializable {

    public AuditoriaDTO() {
    }

private Integer consecutivo;
private String folio;
private String auditoria_tecnica;
private String fecha_atp;

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

    public String getAuditoria_tecnica() {
        return auditoria_tecnica;
    }

    public void setAuditoria_tecnica(String auditoria_tecnica) {
        this.auditoria_tecnica = auditoria_tecnica;
    }

    public String getFecha_atp() {
        return fecha_atp;
    }

    public void setFecha_atp(String fecha_atp) {
        this.fecha_atp = fecha_atp;
    }

    
}
