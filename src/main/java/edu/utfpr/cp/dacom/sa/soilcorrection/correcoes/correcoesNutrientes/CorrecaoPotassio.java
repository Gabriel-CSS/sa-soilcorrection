package edu.utfpr.cp.dacom.sa.soilcorrection.correcoes.correcoesNutrientes;

import edu.utfpr.cp.dacom.sa.soilcorrection.correcoes.interfaces.ICorrecaoNutriente;
import edu.utfpr.cp.dacom.sa.soilcorrection.correcoes.interfaces.ICorrecaoNutrienteQuantidadeAplicar;
import edu.utfpr.cp.dacom.sa.soilcorrection.enums.fontes.fonteNutrientes.FontePotassio;

public class CorrecaoPotassio 
        implements 
            ICorrecaoNutriente<FontePotassio>,
            ICorrecaoNutrienteQuantidadeAplicar<FontePotassio> {

    public double calculaNecessidadeAdicionarCMolcDm3 (
        double teorSolo,
        double participacaoCTCExistente,
        double participacaoCTCDesejada) {

            if (teorSolo <= 0) {
                throw new IllegalArgumentException();
            }

            if (participacaoCTCExistente <= 0) {
                throw new IllegalArgumentException();
            }

            if (participacaoCTCDesejada <= 0) {
                throw new IllegalArgumentException();
            }

            return (teorSolo 
                    * participacaoCTCDesejada 
                    / participacaoCTCExistente) 
                    - teorSolo;
    }

}
