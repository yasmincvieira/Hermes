package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import models.Chamado;
import models.ChamadoDAO;
import view.TelaHistoricoDeChamados;
import view.TelaVizuChamados;

public class HistoricoController {

    private TelaHistoricoDeChamados telaHistorico;
    private TelaVizuChamados telaDetalhes;
    private ChamadoDAO dao;
    private Navegador navegador;

    public HistoricoController(TelaHistoricoDeChamados telaHistorico, TelaVizuChamados telaDetalhes, ChamadoDAO dao, Navegador navegador) {
        this.telaHistorico = telaHistorico;
        this.telaDetalhes = telaDetalhes;
        this.dao = dao;
        this.navegador = navegador;
        
        this.telaDetalhes.voltar(e -> {
            navegador.navegarPara("HISTORICO");
        });
    }

    public void carregarHistorico() {
        if (navegador.getUsuarioLogado() == null) return;
        
        int idUsuario = navegador.getUsuarioLogado().getId();
        List<Chamado> chamados = dao.listarChamadosPorUsuario(idUsuario);

        ActionListener verDetalhesListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idChamado = Integer.parseInt(e.getActionCommand());
                abrirDetalhes(idChamado, chamados);
            }
        };

        telaHistorico.atualizarChamados(chamados, verDetalhesListener);
    }

    private void abrirDetalhes(int idChamado, List<Chamado> chamados) {
        Chamado selecionado = null;
        for (Chamado c : chamados) {
            if (c.getIdChamado() == idChamado) {
                selecionado = c;
                break;
            }
        }

        if (selecionado != null) {
            telaDetalhes.preencherDados(selecionado);
            navegador.navegarPara("DETALHES_CHAMADO");
        }
    }
}
