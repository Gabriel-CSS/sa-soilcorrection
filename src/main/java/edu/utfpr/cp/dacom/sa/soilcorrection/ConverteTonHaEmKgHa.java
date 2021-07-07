package edu.utfpr.cp.dacom.sa.soilcorrection;

public class ConverteTonHaEmKgHa implements Conversao<Double, Double> {

    @Override
    public Double converte(Double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException();
        }

        return valor * 1000;
    }
}