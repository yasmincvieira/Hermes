package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Chamado;
import models.ChamadoDAO;
import view.TelaHistoricoDeChamadosADM;
import view.TelaNovoChamadosADM;
import view.TelaVizuChamadosADM;

public class HistoricoControllerADM {

    private TelaNovoChamadosADM telaNovosChamados;
    private TelaHistoricoDeChamadosADM telaHistoricoGeral;
    private TelaVizuChamadosADM telaDetalhesADM;
    private ChamadoDAO dao;
    private Navegador navegador;

    public HistoricoControllerADM(TelaNovoChamadosADM telaNovosChamados, TelaHistoricoDeChamadosADM telaHistoricoGeral, 
                                 TelaVizuChamadosADM telaDetalhesADM, ChamadoDAO dao, Navegador navegador) {
        this.telaNovosChamados = telaNovosChamados;
        this.telaHistoricoGeral = telaHistoricoGeral;
        this.telaDetalhesADM = telaDetalhesADM;
        this.dao = dao;
        this.navegador = navegador;

        this.telaDetalhesADM.setAtualizar(e -> atualizarStatusChamado());
        
        this.telaDetalhesADM.setVoltar(e -> {
            navegador.navegarPara("INICIO ADMIN");
        });
    }

    public void carregarChamados() {
        List<Chamado> todos = dao.listarChamados();
        List<Chamado> novos = new ArrayList<>();
        List<Chamado> historico = new ArrayList<>();

        for (Chamado c : todos) {
            if (c.getStatus() == null || c.getStatus().trim().isEmpty() || "Em análise".equalsIgnoreCase(c.getStatus())) {
                novos.add(c);
            } else {
                historico.add(c);
            }
        }

        ActionListener verDetalhesListener = e -> {
            String cmd = e.getActionCommand();
            if (cmd != null && !cmd.isEmpty()) {
                int id = Integer.parseInt(cmd);
                abrirDetalhes(id);
            }
        };

        ActionListener excluirListener = e -> {
            String cmd = e.getActionCommand();
            if (cmd != null && !cmd.isEmpty()) {
                int id = Integer.parseInt(cmd);
                int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este chamado?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    dao.excluirChamado(id);
                    carregarChamados();
                }
            }
        };

        telaNovosChamados.atualizarChamados(novos, verDetalhesListener, excluirListener);
        telaHistoricoGeral.atualizarChamados(historico, verDetalhesListener, excluirListener);
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

        dao.atualizarStatus(id, novoStatus);
        JOptionPane.showMessageDialog(telaDetalhesADM, "Status atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        carregarChamados();
        
        if ("Em análise".equalsIgnoreCase(novoStatus)) {
            navegador.navegarPara("NOVO CHAMADO ADMIN");
        } 
        else {
            navegador.navegarPara("HISTORICO ADMIN");
        }
    }

}
