package edu.utfpr.cp.dacom.sa.soilcorrection.correcoes.correcoesNutrientes;

import edu.utfpr.cp.dacom.sa.soilcorrection.correcoes.interfaces.ICorrecaoNutriente;
import edu.utfpr.cp.dacom.sa.soilcorrection.enums.fontes.fonteNutrientes.FonteCalcioMagnesio;

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

    public String calculaPorcentagemIdealCalcio(int texturaSolo) {

        if (texturaSolo <= 0 || texturaSolo > 2) {
            throw new IllegalArgumentException();
        }

        if (texturaSolo == 1) {
            return "45 a 55";
        }

        return "35 a 40";
    }

    public String calculaPorcentagemIdealMagnesio(int texturaSolo) {

        if (texturaSolo <= 0) {
            throw new IllegalArgumentException();
        }

        if (texturaSolo > 2) {
            throw new IllegalArgumentException();
        }

        if (texturaSolo == 1) {
            return "10 a 15";
        }

        return "8 a 12";
    }

    public double calculaPorcentagemAtualCalcio(
            double calcio,
            double magnesio,
            double potassio,
            double hidrogenioAluminio) {

        var somaNutrientes = somaNutrientes(calcio, magnesio, potassio, hidrogenioAluminio);

        return calcio / somaNutrientes * 100;
    }

    public double calculaPorcentagemAtualMagnesio(
            double calcio,
            double magnesio,
            double potassio,
            double hidrogenioAluminio) {

        var somaNutrientes = somaNutrientes(calcio, magnesio, potassio, hidrogenioAluminio);

        return magnesio / somaNutrientes * 100;
    }

    public double somaNutrientes(
        double calcio,
        double magnesio,
        double potassio,
        double hidrogenioAluminio) {
        
        if (calcio <= 0) {
            throw new IllegalArgumentException();
        }
    
        if (magnesio <= 0) {
            throw new IllegalArgumentException();
        }
    
        if (potassio <= 0) {
            throw new IllegalArgumentException();
        }
    
        if (hidrogenioAluminio <= 0) {
            throw new IllegalArgumentException();
        }

        return calcio + magnesio + potassio + hidrogenioAluminio;
    }

    public double calculaPartCalcioAposCorrecao(
        double calcio,
        double magnesio,
        double potassio,
        double hidrogenioAluminio,
        double qtdeCalcioAdicionadaHa,
        double qtdeCaOFosfatagemHa) {

        if (qtdeCalcioAdicionadaHa <= 0) {
            throw new IllegalArgumentException();
        }
        
        if (qtdeCaOFosfatagemHa <= 0) {
            throw new IllegalArgumentException();
        }

        var somaNutrientes = somaNutrientes(calcio, magnesio, potassio, hidrogenioAluminio);

        return (calcio + qtdeCalcioAdicionadaHa + qtdeCaOFosfatagemHa) / somaNutrientes * 100;
    }

    public double calculaPartMagnesioAposCorrecao(
        double calcio,
        double magnesio,
        double potassio,
        double hidrogenioAluminio,
        double magnesioAposCorrecao) {

        if (magnesioAposCorrecao <= 0) {
            throw new IllegalArgumentException();
        }

        var somaNutrientes = somaNutrientes(calcio, magnesio, potassio, hidrogenioAluminio);

        return magnesioAposCorrecao / somaNutrientes * 100;
    }

    public double calculaVAtual(
        double calcio,
        double magnesio,
        double potassio,
        double hidrogenioAluminio) {

        var somaNutrientes = somaNutrientes(calcio, magnesio, potassio, hidrogenioAluminio);
        
        return (100 * (calcio + magnesio + potassio)) / somaNutrientes;
    }

    public String calculaVIdeal(int texturaSolo) {

        if (texturaSolo <= 0 || texturaSolo > 2) {
            throw new IllegalArgumentException();
        }

        if (texturaSolo == 1) {
            return "60 a 70%";
        }

        return "50%";
    }

    public double calculaVAposCorrecao(
        double partCalcioAposCorrecao,
        double partMagnesioAposCorrecao,
        double partPotassioAposCorrecao) {

        if (partCalcioAposCorrecao <= 0) {
            throw new IllegalArgumentException();
        }
            
        if (partMagnesioAposCorrecao <= 0) {
            throw new IllegalArgumentException();
        }
        
        if (partPotassioAposCorrecao <= 0) {
            throw new IllegalArgumentException();
        }
        
        return partCalcioAposCorrecao + partMagnesioAposCorrecao + partPotassioAposCorrecao;
    }
}
