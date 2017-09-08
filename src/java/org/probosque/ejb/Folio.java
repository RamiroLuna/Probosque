package org.probosque.ejb;

import org.probosque.dto.interfaces.FolioPredioInterface;

public  class Folio implements FolioPredioInterface {

    @Override
    public String getFolioPredio(Integer estado, Integer region, Integer municipio, Integer localidad) {
        StringBuilder folioPredio = new StringBuilder();
        folioPredio.append(estado).append("0").append(region);
        if (municipio < 10) {
            folioPredio.append("00").append(municipio);
        } else {
            if (municipio > 9 && municipio < 100) {
                folioPredio.append("0").append(municipio);
            } else {
                folioPredio.append(municipio);
            }
        }
        if (localidad < 10) {
            folioPredio.append("000").append(localidad);
        } else if (localidad > 9 && localidad < 100) {
            folioPredio.append("00").append(localidad);
        } else if (localidad > 99 && localidad < 1000) {
            folioPredio.append("0").append(localidad);
        } else {
            folioPredio.append(localidad);
        }
        return folioPredio.toString();

    }

}
