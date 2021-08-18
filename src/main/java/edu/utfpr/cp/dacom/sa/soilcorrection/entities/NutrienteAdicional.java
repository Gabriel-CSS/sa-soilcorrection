package edu.utfpr.cp.dacom.sa.soilcorrection.entities;

import edu.utfpr.cp.dacom.sa.soilcorrection.enums.NomeNutrienteAdicional;
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
