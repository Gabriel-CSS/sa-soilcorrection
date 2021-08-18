package edu.utfpr.cp.dacom.sa.soilcorrection.correcoes.interfaces;

import edu.utfpr.cp.dacom.sa.soilcorrection.enums.fontes.interfaces.IFonteNutriente;
import lombok.NonNull;

public interface ICorrecaoNutrienteQuantidadeAplicar<T extends IFonteNutriente> {
    
    public default double calculaQuantidadeAplicar(
        double necessidade, 
        @NonNull T fonteNutriente) {

        if (necessidade <= 0) {
            throw new IllegalArgumentException();
        }

        return necessidade / fonteNutriente.getTeorFonte();
    }
}
