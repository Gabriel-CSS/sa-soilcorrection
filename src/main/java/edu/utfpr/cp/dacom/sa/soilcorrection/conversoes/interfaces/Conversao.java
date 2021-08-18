package edu.utfpr.cp.dacom.sa.soilcorrection.conversoes.interfaces;

import lombok.NonNull;

public interface Conversao<T, R> {

    public R converte(@NonNull T valor);
}
