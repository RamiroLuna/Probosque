package org.probosque.dto;

import java.io.Serializable;

public class ResultInteger implements Serializable {

    public ResultInteger() {
        super();
    }

private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
    
}
