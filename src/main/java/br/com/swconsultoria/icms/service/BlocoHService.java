package br.com.swconsultoria.icms.service;

import br.com.swconsultoria.efd.icms.registros.blocoH.BlocoH;
import br.com.swconsultoria.efd.icms.registros.blocoH.RegistroH001;

public class BlocoHService {

    private static BlocoH blocoH;

    private BlocoHService() {}

    public static BlocoH getBloco() {
        blocoH = new BlocoH();
        preencherRegistroH001();
        return blocoH;
    }

    private static void preencherRegistroH001() {
        RegistroH001 registroH001 = new RegistroH001();
        registroH001.setInd_mov("1");
        blocoH.setRegistroH001(registroH001);
    }
}