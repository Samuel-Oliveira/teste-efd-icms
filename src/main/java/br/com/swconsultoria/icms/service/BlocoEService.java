package br.com.swconsultoria.icms.service;

import br.com.swconsultoria.efd.icms.registros.blocoE.BlocoE;
import br.com.swconsultoria.efd.icms.registros.blocoE.RegistroE001;
import br.com.swconsultoria.efd.icms.registros.blocoE.RegistroE100;
import br.com.swconsultoria.efd.icms.registros.blocoE.RegistroE110;
import br.com.swconsultoria.icms.util.Util;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BlocoEService {

    private static BlocoE blocoE;

    private BlocoEService() {}

    public static BlocoE getBloco() {
        blocoE = new BlocoE();
        preencherRegistroE001();
        preencherRegistroE100();
        return blocoE;
    }

    private static void preencherRegistroE001() {
        RegistroE001 registroE001 = new RegistroE001();
        registroE001.setInd_mov("0");
        blocoE.setRegistroE001(registroE001);
    }

    private static void preencherRegistroE100() {

        RegistroE100 registroE100 = new RegistroE100();
        registroE100.setDt_ini(Util.dataSpeed(LocalDate.of(2021, 3, 1)));
        registroE100.setDt_fin(Util.dataSpeed(LocalDate.of(2021, 3, 31)));
        registroE100.setRegistroE110(preencherRegistroE110());

        blocoE.getRegistroE100().add(registroE100);
    }

    private static RegistroE110 preencherRegistroE110() {
        RegistroE110 registroE110 = new RegistroE110();

        registroE110.setVl_tot_debitos(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_aj_debitos(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_tot_aj_debitos(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_estornos_cred(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_tot_creditos(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_aj_creditos(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_tot_aj_creditos(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_estornos_deb(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_sld_credor_ant(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_sld_apurado(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_tot_ded(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_icms_recolher(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setVl_sld_credor_transportar(Util.valorSpeed2Casas(BigDecimal.ZERO));
        registroE110.setDeb_esp(Util.valorSpeed2Casas(BigDecimal.ZERO));
        return registroE110;

    }

}
