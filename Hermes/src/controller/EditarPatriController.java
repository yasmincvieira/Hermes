/*package controller;

import java.util.List;

import javax.swing.JOptionPane;

import models.Espaco;
import models.Patrimonio;
import models.PatrimonioDAO;
import view.TelaCadastrarPatrimonio;
import view.TelaEditarPatrimonio;
import view.TelaTabelaPatrimonios;

public class EditarPatriController {
	
	private TelaEditarPatrimonio telaEditarPatrimonio;
	private TelaTabelaPatrimonios telaTabelaPatrimonios;
	private PatrimonioDAO patrimonioDAO;
	private Navegador navegador;
	
	

	public EditarPatriController(TelaTabelaPatrimonios telaTabelaPatrimonios, TelaEditarPatrimonio telaEditarPatrimonio,
			TelaCadastrarPatrimonio telaCadastrarPatrimonio, PatrimonioDAO patrimonioDAO, Navegador navegador,Menu menu) {
		super();
		
		this.telaTabelaPatrimonios = telaTabelaPatrimonios;
		this.telaEditarPatrimonio = telaEditarPatrimonio;
		this.patrimonioDAO = patrimonioDAO;
		this.navegador = navegador;
		
	    btnSalvar.addActionListener(e -> salvarAlteracoes());
	    }

	    private void carregarEspacos() {
	        try {
	            List<Espaco> espacos = espacoDAO.listarTodos();
	            for (Espaco esp : espacos) {
	                cbEspaco.addItem(esp);
	            }
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Erro ao carregar espaços: " + ex.getMessage());
	        }
	    }

	    public void preencherCampos(String id) {
	        try {
	            Patrimonio p = patrimonioDAO.buscarPorId(id);
	            if (p != null) {
	                tfID.setText(p.getId_patrimonio());  
	                tfPatrimonio.setText(p.getNome());
	                cbStatus.setSelectedItem(p.getStatus());

	            
	                for (int i = 0; i < cbEspaco.getItemCount(); i++) {

	                    Espaco espacoCombo = cbEspaco.getItemAt(i);

	                    if (espacoCombo != null
	                            && espacoCombo.getId_espaco() != null
	                            && p.getEspaco() != null
	                            && p.getEspaco().getId_espaco() != null
	                            && espacoCombo.getId_espaco()
	                                    .equals(p.getEspaco().getId_espaco())) {

	                        cbEspaco.setSelectedIndex(i);
	                        break;
	                    }
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "Patrimônio não encontrado.");
	            }
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Erro ao buscar: " + ex.getMessage());
	        }
	    }

	    private void salvarAlteracoes() {
	        try {
	            Espaco espacoSelecionado = (Espaco) cbEspaco.getSelectedItem();

	            Patrimonio p = new Patrimonio();
	            p.setId_patrimonio(tfID.getText().trim()); 
	            p.setNome(tfPatrimonio.getText().trim());
	            p.setEspaco(espacoSelecionado);
	            p.setStatus((String) cbStatus.getSelectedItem());

	            boolean sucesso = patrimonioDAO.atualizar(p);

	            if (sucesso) {
	                JOptionPane.showMessageDialog(this, "Patrimônio atualizado com sucesso!");
	            } else {
	                JOptionPane.showMessageDialog(this, "Nenhum registro foi atualizado.");
	            }
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
	        }
	    }


		
		this.preencherCampos();

	}
	
	public void preencherCampos() {
		Patrimonio patrimonioAdicionado = navegador.getPatrimonioAdicionado();
		
		
	if  (patrimonioAdicionado != null) {
		String id = patrimonioAdicionado.getId();
		telaEditarPatrimonio.preencherCampos(id);
	}
	}
	
	
}*/
