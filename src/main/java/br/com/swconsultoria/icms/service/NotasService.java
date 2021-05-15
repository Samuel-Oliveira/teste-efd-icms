package br.com.swconsultoria.icms.service;

import br.com.swconsultoria.icms.to.NotaEletronicaTo;
import br.com.swconsultoria.icms.to.enums.IndPagamento;
import br.com.swconsultoria.icms.to.enums.TipoFrete;
import br.com.swconsultoria.icms.to.enums.TipoOperacao;
import br.com.swconsultoria.icms.util.Util;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNfeProc;
import br.com.swconsultoria.nfe.util.XmlNfeUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotasService {

    private static String removeAcentos(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replace('&', 'E');
    }

    public static List<NotaEletronicaTo> getListaNotas() throws JAXBException, IOException {

        List<NotaEletronicaTo> notas = new ArrayList<>();
        List<String> xmls = Arrays.asList(
                "/d/teste/efd/Nota1.xml",
                "/d/teste/efd/Nota2.xml",
                "/d/teste/efd/Nota3.xml",
                "/d/teste/efd/Nota4.xml",
                "/d/teste/efd/Nota5.xml"
        );

        for (String arqXml : xmls) {
            notas.add(montaNota(XmlNfeUtil.leXml(arqXml)));
        }

        return notas;
    }

    private static NotaEletronicaTo montaNota(String xml) throws JAXBException {
        TNfeProc nfe = XmlNfeUtil.xmlToObject(removeAcentos(xml), TNfeProc.class);

        NotaEletronicaTo notaEletronica = new NotaEletronicaTo();

        notaEletronica.setCfop(nfe.getNFe().getInfNFe().getDet().get(0).getProd().getCFOP());
        notaEletronica.setIndPagamento(IndPagamento.A_VISTA);
        notaEletronica.setValor(new BigDecimal(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVNF()));
        notaEletronica.setTipoOperacao(TipoOperacao.SAIDA);
        notaEletronica.setTipoFrete(TipoFrete.getTipoFrete(nfe.getNFe().getInfNFe().getTransp().getModFrete()));
        notaEletronica.setSerie(nfe.getNFe().getInfNFe().getIde().getSerie());
        notaEletronica.setNumeroNota(Long.valueOf(nfe.getNFe().getInfNFe().getIde().getNNF()));
        notaEletronica.setModelo(nfe.getNFe().getInfNFe().getIde().getMod());
        notaEletronica.setDataNota(Util.dataNfeToLocalDateTime(nfe.getNFe().getInfNFe().getIde().getDhEmi()));
        notaEletronica.setChave(nfe.getNFe().getInfNFe().getId().substring(3));

        notaEletronica.setNomeDestinatario(nfe.getNFe().getInfNFe().getDest().getXNome());
        notaEletronica.setCpfCnpjDestinatario(Util.verifica(nfe.getNFe().getInfNFe().getDest().getCNPJ()).orElse(nfe.getNFe().getInfNFe().getDest().getCPF()));
        notaEletronica.setInscricaoEstadualDestinatario(nfe.getNFe().getInfNFe().getDest().getIE());
        notaEletronica.setNumeroEnderecoDestinatario(nfe.getNFe().getInfNFe().getDest().getEnderDest().getNro());
        notaEletronica.setEnderecoDestinatario(nfe.getNFe().getInfNFe().getDest().getEnderDest().getXLgr());
        notaEletronica.setComplementoEnderecoDestinatario(nfe.getNFe().getInfNFe().getDest().getEnderDest().getXCpl());
        notaEletronica.setCMunicipioDestinatario(nfe.getNFe().getInfNFe().getDest().getEnderDest().getCMun());
        notaEletronica.setSetorDestinatario(nfe.getNFe().getInfNFe().getDest().getEnderDest().getXBairro());

        return notaEletronica;
    }
}
