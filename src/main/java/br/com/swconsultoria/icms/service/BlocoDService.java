package br.com.swconsultoria.icms.service;

import br.com.swconsultoria.efd.icms.registros.blocoD.BlocoD;
import br.com.swconsultoria.efd.icms.registros.blocoD.RegistroD001;

public class BlocoDService {

    private static BlocoD blocoD;

    private BlocoDService() {}

    public static BlocoD getBloco() {
        blocoD = new BlocoD();
        preencherRegistroD001();
        return blocoD;
    }

    private static void preencherRegistroD001() {
        RegistroD001 registroD001 = new RegistroD001();
        registroD001.setInd_mov("1");
        blocoD.setRegistroD001(registroD001);
    }
}
