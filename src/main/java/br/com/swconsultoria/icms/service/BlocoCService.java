package br.com.swconsultoria.icms.service;

import br.com.swconsultoria.efd.icms.registros.blocoC.BlocoC;
import br.com.swconsultoria.efd.icms.registros.blocoC.RegistroC001;
import br.com.swconsultoria.efd.icms.registros.blocoC.RegistroC100;
import br.com.swconsultoria.efd.icms.registros.blocoC.RegistroC190;
import br.com.swconsultoria.icms.to.NotaEletronicaTo;
import br.com.swconsultoria.icms.util.Util;

import java.util.Collections;
import java.util.List;

public class BlocoCService {

    private static BlocoC blocoC;

    private BlocoCService() {}

    public static BlocoC getBloco(List<NotaEletronicaTo> listaNotas) {
        blocoC = new BlocoC();
        preencherRegistroC001();
        preencherRegistroC100(listaNotas);
        return blocoC;
    }

    private static void preencherRegistroC001() {
        RegistroC001 registroC001 = new RegistroC001();
        registroC001.setInd_mov("0");
        blocoC.setRegistroC001(registroC001);
    }

    private static void preencherRegistroC100(List<NotaEletronicaTo> listaNotas) {

        listaNotas.forEach(nota -> {
            RegistroC100 registroC100 = new RegistroC100();
            registroC100.setInd_oper(nota.getTipoOperacao().getDescricao());
            registroC100.setInd_emit("0");
            registroC100.setCod_part(nota.getCpfCnpjDestinatario());
            registroC100.setCod_mod(nota.getModelo());
            registroC100.setCod_sit("00");
            registroC100.setSer(nota.getSerie());
            registroC100.setNum_doc(String.valueOf(nota.getNumeroNota()));
            registroC100.setChv_nfe(nota.getChave());
            registroC100.setDt_doc(Util.dataSpeed(nota.getDataNota()));
            registroC100.setDt_e_s(Util.dataSpeed(nota.getDataNota()));
            registroC100.setVl_doc(Util.valorSpeed2Casas(nota.getValor()));
            registroC100.setInd_pagto(nota.getIndPagamento().getDescricao());
            registroC100.setVl_desc("0");
            registroC100.setVl_abat_nt("0");
            registroC100.setVl_merc(Util.valorSpeed2Casas(nota.getValor()));
            registroC100.setInd_frt(nota.getTipoFrete().getDescricao());
            registroC100.setVl_frt("0");
            registroC100.setVl_seg("0");
            registroC100.setVl_out_da("0");
            registroC100.setVl_bc_icms("0");
            registroC100.setVl_icms("0");
            registroC100.setVl_bc_icms_st("0");
            registroC100.setVl_icms_st("0");
            registroC100.setVl_ipi("0");
            registroC100.setVl_pis("0");
            registroC100.setVl_cofins("0");
            registroC100.setVl_pis_st("0");
            registroC100.setVl_cofins_st("0");

            registroC100.getRegistroC190().addAll(preencherRegistroC190(nota));
            blocoC.getRegistroC100().add(registroC100);
        });

    }

    private static List<RegistroC190> preencherRegistroC190(NotaEletronicaTo nota) {

        RegistroC190 registroC190 = new RegistroC190();

        registroC190.setCst_icms("000");
        registroC190.setCfop(nota.getCfop());
        registroC190.setAliq_icms("0");
        registroC190.setVl_opr(Util.valorSpeed2Casas(nota.getValor()));
        registroC190.setVl_bc_icms("0");
        registroC190.setVl_icms("0");
        registroC190.setVl_bc_icms_st("0");
        registroC190.setVl_icms_st("0");
        registroC190.setVl_red_bc("0");
        registroC190.setVl_red_bc("0");
        registroC190.setVl_ipi("0");

        return Collections.singletonList(registroC190);
    }

}
