package br.com.swconsultoria.icms;

import br.com.swconsultoria.efd.icms.bo.GerarEfdIcms;
import br.com.swconsultoria.efd.icms.registros.EfdIcms;
import br.com.swconsultoria.icms.service.*;
import br.com.swconsultoria.icms.to.NotaEletronicaTo;
import br.com.swconsultoria.icms.util.Util;

import java.util.List;

public class Principal {

    public static void main(String[] args) {
        try {
            System.out.println("Extraindo dados das Notas");
            List<NotaEletronicaTo> listaNotas = NotasService.getListaNotas();

            System.out.println("Preenchendo os Blocos...");
            EfdIcms efd = new EfdIcms();
            efd.setBloco0(Bloco0Service.getBloco(listaNotas));
            efd.setBlocoB(BlocoBService.getBloco());
            efd.setBlocoC(BlocoCService.getBloco(listaNotas));
            efd.setBlocoD(BlocoDService.getBloco());
            efd.setBlocoE(BlocoEService.getBloco());
            efd.setBlocoG(BlocoGService.getBloco());
            efd.setBlocoH(BlocoHService.getBloco());
            efd.setBlocoK(BlocoKService.getBloco());
            efd.setBloco1(Bloco1Service.getBloco());

            System.out.println("Gerando contadores e conteudo...");
            StringBuilder sb = new StringBuilder();
            GerarEfdIcms.gerar(efd, sb);

            System.out.println("Salvar Arquivo...");
            String spedConteudo = sb.toString();
            String caminhoArquivo = Util.criarArquivo("/tmp/efd", "sped-icms.txt", spedConteudo);
            System.out.println("Processo Finalizado. Arquivo Gerado em: "+caminhoArquivo);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
