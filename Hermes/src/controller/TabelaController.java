//package controller;
//
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.List;
//
//import javax.swing.JOptionPane;
//
//import models.Patrimonio;
//import models.PatrimonioDAO;
//import models.Usuario;
//import models.UsuarioDAO;
//import view.TelaTabelaPatrimonios;
//
//
//public class TabelaController {
//	
//	private TelaTabelaPatrimonios telaTabelaPatrimonios;
//	private PatrimonioDAO patrimonioDAO;
//	private Navegador navegador;
//
//	public TabelaController(TelaTabelaPatrimonios telaTabelaPatrimonios, Navegador navegador, PatrimonioDAO patrimonioDao ) {
//		super();
//		this.telaTabelaPatrimonios= telaTabelaPatrimonios;
//		this.patrimonioDAO = patrimonioDAO;
//		
//	    carregarTabela();
//	    
//	    this.telaTabelaPatrimonios.excluirPatri(e -> {
//	    	excluirPatrimonio();
//		});
//	    
//	    this.telaTabelaPatrimonios.editarPatri(e -> {
//	    	atualizarPatrimonio();
//	    });
//	    
//	    this.telaTabelaPatrimonios.adicionarPatri(e -> {
//	    	adicionarPatrimonio();
//	    });
//	    
//	    
//	    }
//
//	    public void carregarTabela() {
//	        List<Patrimonio> patrimonio = patrimonioDAO.listarpatrimonio();
//	        telaTabelaPatrimonios.preencherTabela(patrimonio);
//	    }
//	    
//	    private void excluirProduto() {
//	        int linhaSelecionada = telaVisualizarTabela.getTable().getSelectedRow();
//	     
//	        int codigo = (int) telaTabelaPatrimonio.getTable().getValueAt(linhaSelecionada, 0);
//
//	        int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
//
//	        if (confirm == JOptionPane.YES_OPTION) {
//	            patrimonioDAO.excluirPatrimonio(id_patrimonio);
//	            carregarTabela();
//	        }
//	    }
//	      
//	     private void atualizarProduto() {
//	    	 
//	    	 int linhaSelecionada = (int) telaVisualizarTabela.getTable().getSelectedRow();
//	    	 int codigo = (int) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 0);
//	    	 
//	    	 if (linhaSelecionada == -1) {
//	    	        JOptionPane.showMessageDialog(null, "Selecione um produto!");
//	    	        return;
//	    	    }
//
//	    	    codigo = (int) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 0);
//	    	    String nome = (String) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 1);
//	    	    String URL = (String) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 2);
//	    	    String marca = (String) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 3);
//	    	    String categorias = (String) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 4);
//	    	    float peso = Float.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 5).toString());
//	    	    float altura = Float.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 6).toString());
//	    	    float largura = Float.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 7).toString());
//	    	    float comprimento = Float.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 8).toString());
//	    	    float PesoBruto = Float.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 9).toString());
//	    	    double preco = Double.parseDouble(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 10).toString());
//
//	    	 int confirm = JOptionPane.showConfirmDialog(null, "Deseja atualizar?", "Confirmação", JOptionPane.YES_NO_OPTION);
//
//		        if (confirm == JOptionPane.YES_OPTION) {
//		        	Produto produto = new Produto(codigo, nome, URL, marca, categorias, PesoBruto, altura, largura, comprimento, preco);
//
//		            produtoDAO.atualizarProduto(produto); 
//
//		            carregarTabela();
//
//		            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
//		        } 
//	    }	
//}