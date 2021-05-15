package br.com.swconsultoria.icms.service;

import br.com.swconsultoria.efd.icms.registros.blocoG.BlocoG;
import br.com.swconsultoria.efd.icms.registros.blocoG.RegistroG001;

public class BlocoGService {

    private static BlocoG blocoG;

    private BlocoGService() {}

    public static BlocoG getBloco() {
        blocoG = new BlocoG();
        preencherRegistroG001();
        return blocoG;
    }

    private static void preencherRegistroG001() {
        RegistroG001 registroG001 = new RegistroG001();
        registroG001.setInd_mov("1");
        blocoG.setRegistroG001(registroG001);
    }
}
