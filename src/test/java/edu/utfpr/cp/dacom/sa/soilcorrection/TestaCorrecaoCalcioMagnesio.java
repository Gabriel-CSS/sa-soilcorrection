package edu.utfpr.cp.dacom.sa.soilcorrection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestaCorrecaoCalcioMagnesio {

    @Test
    public void testaQuantidadeAplicarTonHa() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        var qtdeCorretivo = 1.29;

        assertEquals(1.8428571428571427, correcaoCalcioMagnesio.calculaQuantidadeAplicarTonHa(qtdeCorretivo, 70));
    }

    @Test
    public void testaConverteTonHaEmKgHa() {
        double valotTonHa = 1.85;

        var valorKgHa = new ConverteTonHaEmKgHa().converte(valotTonHa);

        assertEquals(1850, valorKgHa);
    }

    @Test
    public void testaCustoReaisHa() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
        
        var qtdeAplicar = new ConverteTonHaEmKgHa().converte(1.84536405710763);

        assertEquals(922.682028553815, correcaoCalcioMagnesio.calculaCusto(500.0, qtdeAplicar));
    }

    @Test
    public void testaCalculaEnxofreFornecido() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        var qtdeAplicar = new ConverteTonHaEmKgHa().converte(1.84536405710763);//1.85

        assertEquals(922.682028553815, correcaoCalcioMagnesio.calculaCusto(500.0, qtdeAplicar));
    }

    @Test
    public void testaCalculaPorcentagemIdealCalcio() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals("45 a 55", correcaoCalcioMagnesio.calculaPorcentagemIdealCalcio(1));
    }

    @Test
    public void testaCalculaPorcentagemIdealMagnesio() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals("10 a 15", correcaoCalcioMagnesio.calculaPorcentagemIdealMagnesio(1));
    }
    
    @Test
    public void testaCalculaPorcentagemAtualCalcio() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(44.68580294802172, 
            correcaoCalcioMagnesio.calculaPorcentagemAtualCalcio(5.76, 1.63, 0.15, 5.35));
    }
    
    @Test
    public void testaCalculaPorcentagemAtualMagnesio() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(12.645461598138091, 
            correcaoCalcioMagnesio.calculaPorcentagemAtualMagnesio(5.76, 1.63, 0.15, 5.35));
    }

    @Test
    public void testaSomaNutrientes() {
        
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(12.89, 
            correcaoCalcioMagnesio.somaNutrientes(5.76, 1.63, 0.15, 5.35));
    }

    @Test
    public void testaCalculaPartCalcioAposCorrecao() {
        
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(55.000000000000014, 
            correcaoCalcioMagnesio.calculaPartCalcioAposCorrecao(5.76, 1.63, 0.15, 5.35, 1.31217326561778, 0.0173267343822222));
    }

    @Test
    public void testaCalculaPartMagnesioAposCorrecao() {
        
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(13.888111715724902, 
            correcaoCalcioMagnesio.calculaPartMagnesioAposCorrecao(5.76, 1.63, 0.15, 5.35, 1.79017760015694));
    }

    @Test
    public void testaCalculaVAtual() {
        
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(58.494957331264544, 
            correcaoCalcioMagnesio.calculaVAtual(5.76, 1.63, 0.15, 5.35));
    }

    @Test
    public void testaCalculaVIdeal() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals("60 a 70%", correcaoCalcioMagnesio.calculaVIdeal(1));
    }

    @Test
    public void testaCalculaVAposCorrecao() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(71.88811171572492,
            correcaoCalcioMagnesio.calculaVAposCorrecao(55.000000000000014, 13.888111715724902, 3));
    }
}
