package br.com.swconsultoria.icms.service;

import br.com.swconsultoria.efd.icms.registros.bloco1.Bloco1;
import br.com.swconsultoria.efd.icms.registros.bloco1.Registro1001;
import br.com.swconsultoria.efd.icms.registros.bloco1.Registro1010;

public class Bloco1Service {

    private static Bloco1 bloco1;

    private Bloco1Service() {

    }

    public static Bloco1 getBloco() {
        bloco1 = new Bloco1();
        preencherRegistro1001();
        preencherRegistro1010();
        return bloco1;
    }

    private static void preencherRegistro1001() {
        Registro1001 registro1001 = new Registro1001();
        registro1001.setInd_mov("0");
        bloco1.setRegistro1001(registro1001);
    }

    private static void preencherRegistro1010() {
        Registro1010 registro1010 = new Registro1010();

        registro1010.setInd_exp("N");
        registro1010.setInd_ccrf("N");
        registro1010.setInd_comb("N");
        registro1010.setInd_usina("N");
        registro1010.setInd_va("N");
        registro1010.setInd_ee("N");
        registro1010.setInd_cart("N");
        registro1010.setInd_form("N");
        registro1010.setInd_aer("N");
        registro1010.setInd_giaf1("N");
        registro1010.setInd_giaf3("N");
        registro1010.setInd_giaf4("N");
        registro1010.setInd_rest_ressarc_compl_icms("N");

        bloco1.setRegistro1010(registro1010);
    }

}
