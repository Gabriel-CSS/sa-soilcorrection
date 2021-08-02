package edu.utfpr.cp.dacom.sa.soilcorrection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class NutrienteAdicional {

    private final NomeNutrienteAdicional nome;
    private final double teorNutriente;

    private double correcaoAdicional;
}
