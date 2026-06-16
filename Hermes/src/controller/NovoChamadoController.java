package controller;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.Chamado;
import models.ChamadoDAO;
import models.Usuario;
import view.Mensagem;
import view.TelaNovoChamado;

public class NovoChamadoController {

	private TelaNovoChamado chamado;
	private ChamadoDAO dao;
	private Navegador navegador;
<<<<<<< HEAD
	private ContaController contaController;
=======
	private Object inicio;
>>>>>>> origin/branchJulia_voltar

	public NovoChamadoController(TelaNovoChamado chamado, ChamadoDAO dao, Navegador navegador, ContaController contaController) {
		super();
		this.chamado = chamado;
		this.dao = dao;
		this.navegador = navegador;
<<<<<<< HEAD
		this.contaController = contaController;
=======
		this.inicio = inicio;

>>>>>>> origin/branchJulia_voltar
		this.chamado.realizarChamado(e -> {
			realizarChamado();
		});
		
		this.chamado.irInicio(e -> {
			navegador.navegarPara("INICIO");
		});

	}

	private void realizarChamado() {
		String nome = (String) chamado.getcbNome().getSelectedItem();
		String local = (String) chamado.getcbLocal().getSelectedItem();
		String patrimonio = chamado.gettfPatrimonio().getText();
		String descricao = chamado.gettaDescricao().getText();

		if (descricao.trim().isEmpty()) {
			Mensagem.mostrar("Descreva qual é o problema", "Atenção");			
			return;
		}

        Integer idPatrimonio = null;
        if (patrimonio != null && !patrimonio.trim().isEmpty()) {
            try {
            	idPatrimonio = Integer.valueOf(patrimonio);
            } catch (NumberFormatException e) {
            	Mensagem.mostrar("O ID do Patrimônio deve conter apenas números!", "Atenção");                
            	return;
            }
        }
	        
	    int idUsuario = navegador.getUsuarioLogado().getId();
	    Chamado novoChamado = new Chamado(nome, local, idPatrimonio, descricao, idUsuario);
	
	    try {
		dao.adicionarChamado(novoChamado);

		Mensagem.mostrar("Chamado feito com sucesso!", "Sucesso");		
		if (patrimonio != null && !patrimonio.trim().isEmpty()) {
			try {
				idPatrimonio = Integer.valueOf(patrimonio);
			} catch (NumberFormatException e) {
				Mensagem.mostrar("O ID do Patrimônio deve conter apenas números!", "Atenção");				
				return;
			}
		}

		contaController.atualizarContagem();



		chamado.gettaDescricao().setText("");
		chamado.gettfPatrimonio().setText("");
		} catch (Exception e) {

			Mensagem.mostrar("Erro ao salvar chamado: ", "Erro");
			e.printStackTrace();

		}

	    
	
	}
}
