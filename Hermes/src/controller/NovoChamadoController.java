package controller;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.Chamado;
import models.ChamadoDAO;
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
			cadastrarChamado();
		});
		
	}
	private void cadastrarChamado() {
        String nome = view.getName();
        JComboBox local = view.getLocal();
        JTextField idPatrimonioStr = view.getIdPatrimonio();
        JTextArea descricao = view.getDescricao();

        if (descricao.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "A descrição é obrigatória!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idPatrimonio = 0;
        if (!idPatrimonioStr.trim().isEmpty()) {
            try {
                idPatrimonio = Integer.parseInt(idPatrimonioStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "ID do Patrimônio deve ser um número!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Chamado novoChamado = new Chamado(nome, local, idPatrimonio, descricao);
        dao.adicionarChamado(novoChamado);
        
        JOptionPane.showMessageDialog(view, "Chamado realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	

}}
