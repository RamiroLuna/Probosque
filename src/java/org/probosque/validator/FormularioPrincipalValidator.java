/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.validator;

import org.probosque.dto.FormularioPrincipalDTO;

/**
 *
 * @author Mike M
 */
public class FormularioPrincipalValidator {
    
    public FormularioPrincipalDTO getFormularioPrincipalDTO(FormularioPrincipalDTO campos)
       {
        if(campos.getSedemex().trim().isEmpty())
           {
           campos.setSedemex("0");
           }
       if(campos.getDescripcionComoLlegarPredio().trim().isEmpty())
          {
          campos.setDescripcionComoLlegarPredio("");
          }
       if(campos.getLatitud().trim().isEmpty())
          {
          campos.setLatitud("0");
          }
       if(campos.getLongitud().trim().isEmpty())
          {
          campos.setLongitud("0");
          }
       if(campos.getSuperficieTotal().trim().isEmpty())
          {
          campos.setSuperficieTotal("0");
          }
       if(campos.getSuperficieOtrosUsos().trim().isEmpty())
          {
          campos.setSuperficieOtrosUsos("0");
          }
       if(campos.getSuperficieCartografica().trim().isEmpty())
          {
          campos.setSuperficieCartografica("0");
          }
       if(campos.getSuperficieArbolada().trim().isEmpty())
          {
          campos.setSuperficieArbolada("0");
          }
       if(campos.getCuencaEspecifica().trim().isEmpty() || campos.getCuencaEspecifica().equals("-1"))
           {
           campos.setCuencaEspecifica("");
           }
       if(campos.getAreaNaturalProtegida().trim().isEmpty() || campos.getAreaNaturalProtegida().equals("-1") )
           {
           campos.setAreaNaturalProtegida("");
           }
       if(campos.getObservacionesPredio().trim().isEmpty())
           {
           campos.setObservacionesPredio("");
           }
       if(campos.getRegistroForestalNacional().trim().isEmpty())
          {
          campos.setRegistroForestalNacional("");
          }
       if(campos.getTipoTenenciaTierra().trim().isEmpty() || campos.getTipoTenenciaTierra().equals("-1"))
          {
          campos.setTipoTenenciaTierra("0");
          }
        if(campos.getEstatusPredio().trim().isEmpty() || campos.getEstatusPredio().equals("-1"))
          {
          campos.setEstatusPredio("0");
          }
        if(campos.getPermisoAprovechamientoForestal().trim().isEmpty() || campos.getPermisoAprovechamientoForestal().equals("-1"))
          {
          campos.setEstatusPredio("0");
          }
       return campos;
       }
    
}
