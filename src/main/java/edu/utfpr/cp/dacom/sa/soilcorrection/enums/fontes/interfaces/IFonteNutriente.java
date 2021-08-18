package edu.utfpr.cp.dacom.sa.soilcorrection.enums.fontes.interfaces;

import java.util.Set;

import edu.utfpr.cp.dacom.sa.soilcorrection.entities.NutrienteAdicional;

public interface IFonteNutriente {
    
    public double getTeorFonte();
    public Set<NutrienteAdicional> getNutrientesAdicionais();
}
