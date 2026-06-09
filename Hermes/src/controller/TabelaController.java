package controller;

import javax.swing.JOptionPane;

import models.Patrimonio;
import models.PatrimonioDAO;
import view.TelaCadastrarPatrimonio;
import view.TelaTabelaPatrimonios;
import view.TelaEditarPatrimonio;

public class TabelaController {
    private TelaEditarPatrimonio telaEditarPatrimonio;
    private TelaTabelaPatrimonios telaTabelaPatrimonios;
    private PatrimonioDAO patrimonioDAO;
    private Navegador navegador;

    public TabelaController(TelaTabelaPatrimonios telaTabelaPatrimonios, TelaEditarPatrimonio telaEditarPatrimonio,
            TelaCadastrarPatrimonio telaCadastrarPatrimonio, PatrimonioDAO patrimonioDAO, Navegador navegador, Menu menu) {

        this.telaTabelaPatrimonios = telaTabelaPatrimonios;
        this.telaEditarPatrimonio = telaEditarPatrimonio;
        this.patrimonioDAO = patrimonioDAO;
        this.navegador = navegador;

        this.telaEditarPatrimonio.salvar(e -> salvarEdicao());
        this.telaEditarPatrimonio.voltar(e -> navegador.navegarPara("TABELA"));

        this.telaTabelaPatrimonios.excluirPatri(e -> excluirPatrimonio());
        this.telaTabelaPatrimonios.irInicioADM(e -> navegador.navegarPara("INICIO ADMIN"));

        this.telaTabelaPatrimonios.editarPatri(e -> {
            int linha = telaTabelaPatrimonios.getTable().getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um patrimônio.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String id = telaTabelaPatrimonios.getTable().getValueAt(linha, 2).toString();
            Patrimonio p = patrimonioDAO.buscarPorId(id);
            telaEditarPatrimonio.preencherCampos(p);
            navegador.navegarPara("EDITAR PATRIMONIO");
        });
    }

    private void salvarEdicao() {
        Patrimonio p = new Patrimonio();
        p.setId_patrimonio(telaEditarPatrimonio.getIdPatrimonio());
        p.setNome(telaEditarPatrimonio.getNomePatrimonio());
        p.setEspaco(telaEditarPatrimonio.getEspacoSelecionado());
        p.setStatus(telaEditarPatrimonio.getStatusSelecionado());

        boolean sucesso = patrimonioDAO.atualizar(p);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Patrimônio atualizado com sucesso!");
            navegador.navegarPara("TABELA");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar.");
        }
    }

    private void excluirPatrimonio() {
        int linha = telaTabelaPatrimonios.getTable().getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um patrimônio para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = telaTabelaPatrimonios.getTable().getValueAt(linha, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            patrimonioDAO.excluirPatrimonio(id);
        }
    }
}