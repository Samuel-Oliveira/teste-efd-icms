package br.com.swconsultoria.icms.service;

import br.com.swconsultoria.efd.icms.registros.blocoK.BlocoK;
import br.com.swconsultoria.efd.icms.registros.blocoK.RegistroK001;

public class BlocoKService {

    private static BlocoK blocoK;

    private BlocoKService() {}

    public static BlocoK getBloco() {
        blocoK = new BlocoK();
        preencherRegistroK001();
        return blocoK;
    }

    private static void preencherRegistroK001() {
        RegistroK001 registroK001 = new RegistroK001();
        registroK001.setInd_mov("1");
        blocoK.setRegistroK001(registroK001);
    }
}
