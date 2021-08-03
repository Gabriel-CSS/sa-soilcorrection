package edu.utfpr.cp.dacom.sa.soilcorrection;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
public class NutrienteAdicional {

    @NonNull final NomeNutrienteAdicional nome;
    
    @Getter
    private final double teorNutriente;
    
    @Getter @Setter
    private double correcaoAdicional;
}
