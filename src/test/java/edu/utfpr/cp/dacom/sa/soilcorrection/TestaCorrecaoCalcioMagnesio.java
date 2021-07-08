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
    public void testacalculaPorcentagemIdealCalcio() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals("45 a 55", correcaoCalcioMagnesio.calculaPorcentagemIdealCalcio(1));
    }

    @Test
    public void testacalculaPorcentagemIdealMagnesio() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals("10 a 15", correcaoCalcioMagnesio.calculaPorcentagemIdealMagnesio(1));
    }
}
