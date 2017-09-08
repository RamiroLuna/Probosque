/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.probosque.validator;

import org.probosque.dto.PoligonoDTO;

/**
 *
 * @author Ivan Tadeo Huerta
 */
public class FormularioPoligonosValidator {
    public PoligonoDTO getMultiPoligonoDTO(PoligonoDTO campos)
    {
        if(campos.getLatitud().trim().isEmpty()){
            campos.setLatitud("0");
        }
        if(campos.getLongitud().trim().isEmpty()){
            campos.setLongitud("0");
        }
        if(campos.getSuperficie_poligono().trim().isEmpty()){
            campos.setSuperficie_poligono("0");
        }
        if(campos.getSuperficie_cartografica().trim().isEmpty()){
            campos.setSuperficie_cartografica("0");
        }
        if(campos.getSuperficie_arbolada().trim().isEmpty()){
            campos.setSuperficie_arbolada("0");
        }
        if(campos.getSuperficie_otros_usos().trim().isEmpty()){
            campos.setSuperficie_otros_usos("0");
        }
        if(campos.getTipo_clima().trim().isEmpty() || campos.getTipo_clima().equals("-1")){
            campos.setTipo_clima("0");
        }
        if(campos.getTipo_vegetacion().trim().isEmpty() || campos.getTipo_vegetacion().equals("-1")){
            campos.setTipo_vegetacion("0");
        }
        if(campos.getEspecies_arboreas().trim().isEmpty() || campos.getEspecies_arboreas().equals("-1")){
            campos.setEspecies_arboreas("0");
        }
        return campos;
    }            
    
    
    
}
