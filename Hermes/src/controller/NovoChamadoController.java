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
	private ContaController contaController;

	public NovoChamadoController(TelaNovoChamado chamado, ChamadoDAO dao, Navegador navegador, ContaController contaController) {
		super();
		this.chamado = chamado;
		this.dao = dao;
		this.navegador = navegador;
		this.contaController = contaController;
		this.chamado.realizarChamado(e -> {
			realizarChamado();
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
//        if (navegador.getUsuarioLogado() == null) {
//            JOptionPane.showMessageDialog(chamado, "Erro: Nenhum usuário logado!", "Erro", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
	        
	    int idUsuario = navegador.getUsuarioLogado().getId();
	    Chamado novoChamado = new Chamado(nome, local, idPatrimonio, descricao, idUsuario);
	
	    try {
		dao.adicionarChamado(novoChamado);

		Mensagem.mostrar("Chamado feito com sucesso!", "Sucesso");		
		if (patrimonio != null && !patrimonio.trim().isEmpty()) {
			try {
				idPatrimonio = Integer.valueOf(patrimonio);
			} catch (NumberFormatException e) {
				Mensagem.mostrar("O ID do Patrimônio deve conter apenas números!", "Atenção");				return;
			}
		}
	    } catch (Exception e) {
	    	Mensagem.mostrar("Erro ao salvar chamado!", "Erro");			
	    	e.printStackTrace();

		contaController.atualizarContagem();
		JOptionPane.showMessageDialog(chamado, "Chamado feito com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);



		chamado.gettaDescricao().setText("");
		chamado.gettfPatrimonio().setText("");
//// Aqui deu erro  do merge, precisamos ver o codigo
		} catch (Exception e) {

			JOptionPane.showMessageDialog(chamado, "Erro ao salvar chamado: ", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}
	    
//		int idUsuario = navegador.getUsuarioLogado().getId();
//
//		Chamado novoChamado = new Chamado(nome, local, idPatrimonio, descricao, idUsuario);
//
//		try {
//			dao.adicionarChamado(novoChamado);
//			JOptionPane.showMessageDialog(chamado, "Chamado feito com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
//
//		chamado.gettaDescricao().setText("");
//		chamado.gettfPatrimonio().setText("");
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(chamado, "Erro ao salvar chamado: ", "Erro", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}
	    
	
	}
}
