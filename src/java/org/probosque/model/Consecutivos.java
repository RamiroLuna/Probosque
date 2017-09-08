package org.probosque.model;

import java.util.List;
import org.probosque.dto.ResultInteger;

public class Consecutivos {
  public Consecutivos() {
    }
    private Boolean successfull;

    private List<ResultInteger> consecutivo; 

    public Boolean getSuccessfull() {
        return successfull;
    }

    public void setSuccessfull(Boolean successfull) {
        this.successfull = successfull;
    }

    public List<ResultInteger> getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(List<ResultInteger> consecutivo) {
        this.consecutivo = consecutivo;
    }
    

}
