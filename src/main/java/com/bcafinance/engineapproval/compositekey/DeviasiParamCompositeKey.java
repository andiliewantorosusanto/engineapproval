package com.bcafinance.engineapproval.compositekey;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DeviasiParamCompositeKey implements Serializable {
    private String token;
    private String kodeDeviasi;
}
