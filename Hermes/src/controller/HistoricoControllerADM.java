package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import models.Chamado;
import models.ChamadoDAO;
import view.TelaHistoricoDeChamados;
import view.TelaHistoricoDeChamadosADM;
import view.TelaVizuChamados;
import view.TelaVizuChamadosADM;

public class HistoricoControllerADM {
	
	private TelaHistoricoDeChamadosADM telaHistoricoADM;
    private TelaVizuChamadosADM telaDetalhesADM;
    private ChamadoDAO dao;
    private Navegador navegador;
    
    public HistoricoControllerADM(TelaHistoricoDeChamadosADM telaHistoricoADM, TelaVizuChamadosADM telaDetalhesADM, ChamadoDAO dao, Navegador navegador) {
        this.telaHistoricoADM = telaHistoricoADM;
        this.telaDetalhesADM = telaDetalhesADM;
        this.dao = dao;
        this.navegador = navegador;
        
          
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

        telaHistoricoADM.atualizarChamados(chamados, verDetalhesListener);
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
            telaDetalhesADM.preencherDados(selecionado);
            navegador.navegarPara("CHAMADO ADMIN");
        }
    }

}
