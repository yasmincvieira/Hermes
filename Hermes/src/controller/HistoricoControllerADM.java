package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Chamado;
import models.ChamadoDAO;
import view.TelaHistoricoDeChamados;
import view.TelaHistoricoDeChamadosADM;
import view.TelaNovoChamadosADM;
import view.TelaVizuChamados;
import view.TelaVizuChamadosADM;

public class HistoricoControllerADM {
	
	private TelaNovoChamadosADM telaNovosChamado;
    private TelaHistoricoDeChamadosADM telaHistorico;
	private TelaHistoricoDeChamadosADM telaHistoricoADM;
    private TelaVizuChamadosADM telaDetalhesADM;
    private ChamadoDAO dao;
    private Navegador navegador;
    
    public HistoricoControllerADM(TelaHistoricoDeChamadosADM telaHistoricoADM, TelaVizuChamadosADM telaDetalhesADM, ChamadoDAO dao, Navegador navegador) {
        this.telaHistoricoADM = telaHistoricoADM;
        this.telaDetalhesADM = telaDetalhesADM;
        this.dao = dao;
        this.navegador = navegador;
        
        this.telaDetalhesADM.setAtualizarListener(e -> atualizarStatusChamado());
        
        this.telaDetalhesADM.setVoltarListener(e -> {
            navegador.navegarPara("NOVO CHAMADO ADMIN");
        });
    }
    
    public void carregarChamados() {
        List<Chamado> todos = dao.listarChamados();
        List<Chamado> novos = new ArrayList<>();
        List<Chamado> historico = new ArrayList<>();

        for (Chamado c : todos) {
            if (c.getStatus() == null || "Em análise".equalsIgnoreCase(c.getStatus())) {
                novos.add(c);
            } else {
                historico.add(c);
            }
        }

        ActionListener verDetalhesListener = e -> {
            int id = Integer.parseInt(e.getActionCommand());
            abrirDetalhes(id);
        };

        telaNovosChamado.atualizarChamados(novos, verDetalhesListener);
        telaHistorico.atualizarChamados(historico, verDetalhesListener);
    }

    private void abrirDetalhes(int idChamado) {
    	List<Chamado> chamados = dao.listarChamados();
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
    private void atualizarStatusChamado() {
        int id = telaDetalhesADM.getIdChamadoAtual();
        String novoStatus = telaDetalhesADM.getStatusSelecionado();

        try {
            dao.atualizarStatus(id, novoStatus);
            JOptionPane.showMessageDialog(null, "Status atualizado com sucesso!");
            
            carregarChamados();
            
            if ("Em análise".equalsIgnoreCase(novoStatus)) {
                navegador.navegarPara("NOVO CHAMADO ADMIN");
            } else {
                navegador.navegarPara("HISTORICO ADMIN");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar status: " + e.getMessage());
        }
    }

}
