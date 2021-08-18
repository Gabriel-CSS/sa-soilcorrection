package edu.utfpr.cp.dacom.sa.soilcorrection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.utfpr.cp.dacom.sa.soilcorrection.conversoes.ConverteTonHaEmKgHa;
import edu.utfpr.cp.dacom.sa.soilcorrection.correcoes.correcoesNutrientes.CorrecaoCalcioMagnesio;
import edu.utfpr.cp.dacom.sa.soilcorrection.enums.fontes.fonteNutrientes.FonteCalcioMagnesio;

public class TestaCorrecaoCalcioMagnesio {

    @Test
    public void testaQuantidadeAplicarTonHa() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        var qtdeCorretivo = 1.29;

        assertEquals(1.85, correcaoCalcioMagnesio.calculaQuantidadeAplicarTonHa(qtdeCorretivo, 70), 0.01);
    }

    @Test
    public void testaConverteTonHaEmKgHa() {
        double valotTonHa = 1.85;

        var valorKgHa = new ConverteTonHaEmKgHa().converte(valotTonHa);

        assertEquals(1850, valorKgHa);
    }

    @Test
    public void testaCalculaEnxofreFornecido() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        var qtdeAplicar = 3.50775578515434000000;

        assertEquals(526.16, correcaoCalcioMagnesio.calculaEnxofreFornecido(qtdeAplicar, 4), 0.1);
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

        assertEquals(44.7, correcaoCalcioMagnesio.calculaPorcentagemAtualCalcio(5.76, 1.63, 0.15, 5.35), 0.1);
    }

    @Test
    public void testaCalculaPorcentagemAtualMagnesio() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(12.6, correcaoCalcioMagnesio.calculaPorcentagemAtualMagnesio(5.76, 1.63, 0.15, 5.35), 0.1);
    }

    @Test
    public void testaSomaNutrientes() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(12.89, correcaoCalcioMagnesio.somaNutrientes(5.76, 1.63, 0.15, 5.35));
    }

    @Test
    public void testaCalculaPartCalcioAposCorrecao() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(55.0, correcaoCalcioMagnesio.calculaPartCalcioAposCorrecao(5.76, 1.63, 0.15, 5.35,
                1.31217326561778, 0.0173267343822222), 0.01);
    }

    @Test
    public void testaCalculaPartMagnesioAposCorrecao() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(13.9,
                correcaoCalcioMagnesio.calculaPartMagnesioAposCorrecao(5.76, 1.63, 0.15, 5.35, 1.79017760015694), 0.1);
    }

    @Test
    public void testaCalculaVAtual() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(58.49, correcaoCalcioMagnesio.calculaVAtual(5.76, 1.63, 0.15, 5.35), 0.01);
    }

    @Test
    public void testaCalculaVIdeal() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals("60 a 70%", correcaoCalcioMagnesio.calculaVIdeal(1));
    }

    @Test
    public void testaCalculaVAposCorrecao() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        assertEquals(71.89,
                correcaoCalcioMagnesio.calculaVAposCorrecao(55.000000000000014, 13.888111715724902, 3), 0.01);
    }

    @Test
    public void testaCustoReaisHa() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        var qtdeCalcioMagnesioAplicarKgHa = 1844.76;

        assertEquals(922.68, 
                correcaoCalcioMagnesio.calculaCusto(500.0, qtdeCalcioMagnesioAplicarKgHa), 0.5);
    }

    @Test
    public void testaNutrientesAdicionais() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        var qtdeCalcioMagnesioAplicarKgHa = 1844.76;

        assertEquals(1, correcaoCalcioMagnesio
                .getNutrientesAdicionais(qtdeCalcioMagnesioAplicarKgHa, FonteCalcioMagnesio.GESSO_AGRICOLA).size());

        qtdeCalcioMagnesioAplicarKgHa = 3.51 * 1000;

        assertEquals(526.16,
                correcaoCalcioMagnesio
                        .getNutrientesAdicionais(qtdeCalcioMagnesioAplicarKgHa, FonteCalcioMagnesio.GESSO_AGRICOLA)
                        .stream().findFirst().get().getCorrecaoAdicional(),
                0.5);
    }

}
