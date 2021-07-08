package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoCalcioMagnesio implements ICorrecaoNutriente<FonteCalcioMagnesio> {
    
    public double calculaQuantidadeAplicarTonHa(double qtdeCorretivoAplicar, double prnt) {
        
        if (prnt <= 0) {
            throw new IllegalArgumentException();
        }
        
        if (qtdeCorretivoAplicar <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdeCorretivoAplicar * 100 / prnt;
    }
     
    public double calculaEnxofreFornecido(double qtdeAplicar, int fonteNutriente) {
        
        if (qtdeAplicar <= 0) {
            throw new IllegalArgumentException();
        }
        
        if (fonteNutriente != 4) {
            return 0;
        }

        return qtdeAplicar * 150;
    }
}
