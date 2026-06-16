package controller;

<<<<<<< HEAD
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

=======
>>>>>>> origin/branchJulia_voltar
import javax.swing.JOptionPane;

import models.Patrimonio;
import models.PatrimonioDAO;
<<<<<<< HEAD
import view.Mensagem;
import view.MensagemSN;
=======
import view.TelaCadastrarPatrimonio;
>>>>>>> origin/branchJulia_voltar
import view.TelaTabelaPatrimonios;
import view.TelaEditarPatrimonio;

<<<<<<< HEAD
public class TabelaController  extends ComponentAdapter {
=======
public class TabelaController {
    private TelaEditarPatrimonio telaEditarPatrimonio;
    private TelaTabelaPatrimonios telaTabelaPatrimonios;
    private PatrimonioDAO patrimonioDAO;
    private Navegador navegador;
>>>>>>> origin/branchJulia_voltar

    public TabelaController(TelaTabelaPatrimonios telaTabelaPatrimonios, TelaEditarPatrimonio telaEditarPatrimonio,
            TelaCadastrarPatrimonio telaCadastrarPatrimonio, PatrimonioDAO patrimonioDAO, Navegador navegador, Menu menu) {

<<<<<<< HEAD
	public TabelaController(TelaTabelaPatrimonios telaTabelaPatrimonios, Navegador navegador,
			PatrimonioDAO patrimonioDAO) {
		super();
		this.telaTabelaPatrimonios = telaTabelaPatrimonios;
		this.patrimonioDAO = patrimonioDAO;

		this.telaTabelaPatrimonios.excluirPatri(e -> {
			excluirPatrimonio();
		});
		this.telaTabelaPatrimonios.adicionarPatri(e-> {
			navegador.navegarPara("CADASTRAR PATRIMONIO");
		});
=======
        this.telaTabelaPatrimonios = telaTabelaPatrimonios;
        this.telaEditarPatrimonio = telaEditarPatrimonio;
        this.patrimonioDAO = patrimonioDAO;
        this.navegador = navegador;

        this.telaEditarPatrimonio.salvar(e -> salvarEdicao());
        this.telaEditarPatrimonio.voltar(e -> navegador.navegarPara("TABELA"));
>>>>>>> origin/branchJulia_voltar

        this.telaTabelaPatrimonios.excluirPatri(e -> excluirPatrimonio());
        this.telaTabelaPatrimonios.irInicioADM(e -> navegador.navegarPara("INICIO ADMIN"));

<<<<<<< HEAD
	private void excluirPatrimonio() {
	    int linha = telaTabelaPatrimonios.getLinhaSelecionada();
	    if (linha == -1) {
	        Mensagem.mostrar("Selecione um patrimonio para excluir!", "Atenção");
	        return;
	    }

	    MensagemSN.mostrarSN(
	        "Deseja excluir?",
	        "Confirmação",
	        sim -> {
	            String idString = telaTabelaPatrimonios.getTable().getValueAt(linha, 0).toString();
	            int idPatrimonio = Integer.parseInt(idString);
	            patrimonioDAO.excluirPatrimonio(idPatrimonio);
	            telaTabelaPatrimonios.atualizarTabela();
	            Mensagem.mostrar("Patrimônio excluído com sucesso!", "Sucesso");
	        },
	        nao -> {}
	    );
	}

	public void componentShown(ComponentEvent e) {
		this.atualizarTabela();
	}
	public void atualizarTabela() {
		PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
		List<Patrimonio> lista = patrimonioDAO.listarpatrimonio();
		PatrimonioTableModel model = new PatrimonioTableModel(lista);

	}

}
=======
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
>>>>>>> origin/branchJulia_voltar
