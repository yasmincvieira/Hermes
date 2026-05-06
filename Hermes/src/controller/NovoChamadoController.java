package controller;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.Chamado;
import models.ChamadoDAO;
import models.Usuario;
import view.TelaNovoChamado;

public class NovoChamadoController {
	
	private TelaNovoChamado chamado;
	private ChamadoDAO dao;
	private Navegador navegador;
	
	public NovoChamadoController(TelaNovoChamado chamado, ChamadoDAO dao, Navegador navegador) {
		super();
		this.chamado = chamado;
		this.dao = dao;
		this.navegador = navegador;
		
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
			JOptionPane.showMessageDialog(chamado, "Descreva qual é o problema", "Atenção", JOptionPane.ERROR_MESSAGE);
			return;
		}
        
        Integer idPatrimonio = null;
        if (patrimonio != null && !patrimonio.trim().isEmpty()) {
            try {
            	idPatrimonio = Integer.valueOf(patrimonio);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(chamado, "O ID do Patrimônio deve conter apenas números!");
                return;
            }
        }
	        
	        int idUsuario = navegador.getUsuarioLogado().getId();
	        
	        Chamado novoChamado = new Chamado(nome, local, idPatrimonio, descricao, idUsuario);
	
			try {
			dao.adicionarChamado(novoChamado);
			JOptionPane.showMessageDialog(chamado, "Chamado feito com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			
			chamado.gettaDescricao().setText("");
			chamado.gettfPatrimonio().setText("");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(chamado, "Erro ao salvar chamado: ", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
    		
	}

}