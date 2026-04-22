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
        JComboBox nome = chamado.getcbNome();
        JComboBox local = chamado.getcbLocal();
        JTextField tfPatrimonioStr = chamado.gettfPatrimonio();
        JTextArea descricao = chamado.gettaDescricao();

        if(chamado.gettaDescricao().getText().isEmpty()) {
    			
    		JOptionPane.showMessageDialog(chamado, "Descreva qual o é problema", "Atenção", JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    	Chamado novoChamado = new Chamado();
    	novoChamado.setNome((String)chamado.getcbNome().getSelectedItem());
    	novoChamado.setLocal((String)chamado.getcbLocal().getSelectedItem());
        novoChamado.setIdPatrimonio(chamado.gettfPatrimonio().getText());
        novoChamado.setDescricao(chamado.gettaDescricao().getText());
    	  
        dao.adicionarChamado(novoChamado); 
    	    
        JOptionPane.showMessageDialog(chamado, "Chamado feito com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        this.navegador.navegarPara("INICIO");
    	   
    		
	}

}
