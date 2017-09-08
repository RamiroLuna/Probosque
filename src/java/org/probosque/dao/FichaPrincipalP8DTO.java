package org.probosque.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class FichaPrincipalP8DTO implements Serializable{
@SerializedName("formulario") 
private List<FichaPrincipalP8DTO> registro;    
private String estado;
private String tipo_accion;
private String region;
private String modulopredio_municipio;
private String modulopredio_localidad;
private String anio;
private String modulopredio_cup;
private String razon_social;
private String paraje;
private String coordenadas_utm_x;
private String coordenadas_utm_y;
private String metros_sobre_nivel_mar;
private String fecha_inicio;
private String fecha_termino;
private String zona_critica;
private String total_participantes;
private String vehiculos_sin_irregularidades;
private String vehiculos_revisados;
private String total_personas;
private String numero_orden;
private String tipo_documento;
private String num_documento;
private String dependencia_expide_documento;
private String agencia_ministerio_solicita_dictamen;
private String medidas_seguridad;
private String valor_comercial;
private String impacto_ambiental;
private String reparacion_danio;
private String total_dictamen;
private String observaciones;
private String codigo_identificacion;
private String registro_forestal_nacional;
private String estatus_industria;

    public List<FichaPrincipalP8DTO> getRegistro() {
        return registro;
    }

    public void setRegistro(List<FichaPrincipalP8DTO> registro) {
        this.registro = registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_accion() {
        return tipo_accion;
    }

    public void setTipo_accion(String tipo_accion) {
        this.tipo_accion = tipo_accion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getModulopredio_municipio() {
        return modulopredio_municipio;
    }

    public void setModulopredio_municipio(String modulopredio_municipio) {
        this.modulopredio_municipio = modulopredio_municipio;
    }

    public String getModulopredio_localidad() {
        return modulopredio_localidad;
    }

    public void setModulopredio_localidad(String modulopredio_localidad) {
        this.modulopredio_localidad = modulopredio_localidad;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getModulopredio_cup() {
        return modulopredio_cup;
    }

    public void setModulopredio_cup(String modulopredio_cup) {
        this.modulopredio_cup = modulopredio_cup;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getParaje() {
        return paraje;
    }

    public void setParaje(String paraje) {
        this.paraje = paraje;
    }

    public String getCoordenadas_utm_x() {
        return coordenadas_utm_x;
    }

    public void setCoordenadas_utm_x(String coordenadas_utm_x) {
        this.coordenadas_utm_x = coordenadas_utm_x;
    }

    public String getCoordenadas_utm_y() {
        return coordenadas_utm_y;
    }

    public void setCoordenadas_utm_y(String coordenadas_utm_y) {
        this.coordenadas_utm_y = coordenadas_utm_y;
    }

    public String getMetros_sobre_nivel_mar() {
        return metros_sobre_nivel_mar;
    }

    public void setMetros_sobre_nivel_mar(String metros_sobre_nivel_mar) {
        this.metros_sobre_nivel_mar = metros_sobre_nivel_mar;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public String getZona_critica() {
        return zona_critica;
    }

    public void setZona_critica(String zona_critica) {
        this.zona_critica = zona_critica;
    }

    public String getTotal_participantes() {
        return total_participantes;
    }

    public void setTotal_participantes(String total_participantes) {
        this.total_participantes = total_participantes;
    }

    public String getVehiculos_sin_irregularidades() {
        return vehiculos_sin_irregularidades;
    }

    public void setVehiculos_sin_irregularidades(String vehiculos_sin_irregularidades) {
        this.vehiculos_sin_irregularidades = vehiculos_sin_irregularidades;
    }

    public String getVehiculos_revisados() {
        return vehiculos_revisados;
    }

    public void setVehiculos_revisados(String vehiculos_revisados) {
        this.vehiculos_revisados = vehiculos_revisados;
    }

    public String getTotal_personas() {
        return total_personas;
    }

    public void setTotal_personas(String total_personas) {
        this.total_personas = total_personas;
    }

    public String getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(String numero_orden) {
        this.numero_orden = numero_orden;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getDependencia_expide_documento() {
        return dependencia_expide_documento;
    }

    public void setDependencia_expide_documento(String dependencia_expide_documento) {
        this.dependencia_expide_documento = dependencia_expide_documento;
    }

    public String getAgencia_ministerio_solicita_dictamen() {
        return agencia_ministerio_solicita_dictamen;
    }

    public void setAgencia_ministerio_solicita_dictamen(String agencia_ministerio_solicita_dictamen) {
        this.agencia_ministerio_solicita_dictamen = agencia_ministerio_solicita_dictamen;
    }

    public String getMedidas_seguridad() {
        return medidas_seguridad;
    }

    public void setMedidas_seguridad(String medidas_seguridad) {
        this.medidas_seguridad = medidas_seguridad;
    }

    public String getValor_comercial() {
        return valor_comercial;
    }

    public void setValor_comercial(String valor_comercial) {
        this.valor_comercial = valor_comercial;
    }

    public String getImpacto_ambiental() {
        return impacto_ambiental;
    }

    public void setImpacto_ambiental(String impacto_ambiental) {
        this.impacto_ambiental = impacto_ambiental;
    }

    public String getReparacion_danio() {
        return reparacion_danio;
    }

    public void setReparacion_danio(String reparacion_danio) {
        this.reparacion_danio = reparacion_danio;
    }

    public String getTotal_dictamen() {
        return total_dictamen;
    }

    public void setTotal_dictamen(String total_dictamen) {
        this.total_dictamen = total_dictamen;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCodigo_identificacion() {
        return codigo_identificacion;
    }

    public void setCodigo_identificacion(String codigo_identificacion) {
        this.codigo_identificacion = codigo_identificacion;
    }

    public String getRegistro_forestal_nacional() {
        return registro_forestal_nacional;
    }

    public void setRegistro_forestal_nacional(String registro_forestal_nacional) {
        this.registro_forestal_nacional = registro_forestal_nacional;
    }

    public String getEstatus_industria() {
        return estatus_industria;
    }

    public void setEstatus_industria(String estatus_industria) {
        this.estatus_industria = estatus_industria;
    }

}
