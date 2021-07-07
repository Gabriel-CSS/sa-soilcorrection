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

        var qtdeAplicar = new ConverteTonHaEmKgHa().converte(1.850);

        assertEquals(922.68, correcaoCalcioMagnesio.calculaCusto(500.0, qtdeAplicar));
    }
}
