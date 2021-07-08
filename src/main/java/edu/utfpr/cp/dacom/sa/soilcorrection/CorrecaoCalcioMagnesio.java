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
    
    public String calculaPorcentagemIdealCalcio(int texturaSolo){
        
        if(texturaSolo <= 0 || texturaSolo > 2){
            throw new IllegalArgumentException();
        }
        
        if(texturaSolo == 1){
            return "45 a 55";
        }
    
        return "35 a 40";
    }
    
    public String calculaPorcentagemIdealMagnesio(int texturaSolo){
        
        if(texturaSolo <= 0){
            throw new IllegalArgumentException();
        }
        
        if(texturaSolo > 2){
            throw new IllegalArgumentException();
        }
        
        if(texturaSolo == 1){
            return "10 a 15";
        }
    
        return "8 a 12";
    }
}
