package edu.utfpr.cp.dacom.sa.soilcorrection.enums.fontes.fonteNutrientes;

import java.util.Set;

import edu.utfpr.cp.dacom.sa.soilcorrection.entities.NutrienteAdicional;
import edu.utfpr.cp.dacom.sa.soilcorrection.enums.NomeNutrienteAdicional;
import edu.utfpr.cp.dacom.sa.soilcorrection.enums.fontes.interfaces.IFonteNutriente;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter

public enum FonteFosforo implements IFonteNutriente {
    SUPERFOSFATO_SIMPLES(0.18, Set.of(
        NutrienteAdicional.builder().nome(NomeNutrienteAdicional.ENXOFRE).teorNutriente(0.1).build(),
        NutrienteAdicional.builder().nome(NomeNutrienteAdicional.CALCIO).teorNutriente(0.28).build())),
    SUPERFOSFATO_TRIPO(0.41, Set.of(NutrienteAdicional.builder().nome(NomeNutrienteAdicional.CALCIO).teorNutriente(0.2).build())),
    MAP(0.48, Set.of(NutrienteAdicional.builder().nome(NomeNutrienteAdicional.CALCIO).teorNutriente(0.09).build()));

    private final double teorFonte;
    @NonNull final Set<NutrienteAdicional> nutrientesAdicionais;
}
