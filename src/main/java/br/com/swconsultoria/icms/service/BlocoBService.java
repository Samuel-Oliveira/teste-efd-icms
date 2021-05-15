package br.com.swconsultoria.icms.service;

import br.com.swconsultoria.efd.icms.registros.blocoB.BlocoB;
import br.com.swconsultoria.efd.icms.registros.blocoB.RegistroB001;

public class BlocoBService {

    private static BlocoB blocoB;

    private BlocoBService() {}

    public static BlocoB getBloco() {
        blocoB = new BlocoB();
        preencherRegistroB001();
        return blocoB;
    }

    private static void preencherRegistroB001() {
        RegistroB001 registroB001 = new RegistroB001();
        registroB001.setInd_dad("1");
        blocoB.setRegistroB001(registroB001);
    }

}
