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
	
	private TelaNovoChamado view;
	private ChamadoDAO dao;
	private Navegador navegador;
	
	public NovoChamadoController(TelaNovoChamado view, ChamadoDAO dao, Navegador navegador) {
		super();
		this.view = view;
		this.dao = dao;
		this.navegador = navegador;
		
		this.view.realizarChamado(e -> {
			realizarChamado();
		});
		
	}
	private void realizarChamado() {
		List<Chamado> chamado = dao.listarChamados();
        JComboBox nome = view.getcbNome();
        JComboBox local = view.getcbLocal();
        JTextField tfPatrimonioStr = view.gettfPatrimonio();
        JTextArea descricao = view.gettaDescricao();

        if(view.gettaDescricao().getText().isEmpty()) {
    			
    		JOptionPane.showMessageDialog(null, "Prencha todos os campos");
    		return;
    	}
    	Chamado novoChamado = new Chamado();
    	novoChamado.setNome((String)view.getcbNome().getSelectedItem());
    	novoChamado.setLocal((String)view.getcbLocal().getSelectedItem());
        novoChamado.setIdPatrimonio(view.gettfPatrimonio().getText());
        novoChamado.setDescricao(view.gettaDescricao().getText());
    	  
        dao.adicionarChamado(novoChamado); 
    	    
        JOptionPane.showMessageDialog(null, "Chamado feito com sucesso!");
        this.navegador.navegarPara("INICIO");
    	   
    		
	}

}
