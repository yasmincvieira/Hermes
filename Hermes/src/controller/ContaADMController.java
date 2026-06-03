package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import jakarta.mail.MessagingException;
import models.Usuario;
import models.UsuarioDAO;
import view.TelaConta;
import view.TelaContaADM;
import view.TelaEscolhaAvatar;

public class ContaADMController {

	private TelaContaADM contaADM;
	private UsuarioDAO user;
	private Navegador navegador;

	public ContaADMController(TelaContaADM contaADM, UsuarioDAO user, Navegador navegador, Menu menu) {
		super();
		this.contaADM = contaADM;
		this.user = user;
		this.navegador = navegador;

		this.contaADM.excluirConta(e -> {
			verificarExcluir();

		});
		this.contaADM.editarSenha(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {

				alterarSenha();
			}

		});
		this.contaADM.editarNome(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				alterarNome();
			}
		});
		
		this.preencherDados();
	}

	public void preencherDados() {
	    Usuario usuarioLogado = navegador.getUsuarioLogado();
	    
	    if (usuarioLogado != null) {
	        contaADM.preencherDados(usuarioLogado);
	    } else {
	        System.out.println("Aviso: Tentativa de preencher dados do Admin, mas nenhum usuário está logado ainda.");
	    }
	}


	private void alterarSenha() {
		Usuario usuarioLogado = navegador.getUsuarioLogado(); 
		String codigo = String.valueOf((int) (Math.random() * 900000) + 100000); 

		try {
			EmailService.enviarCodigo(usuarioLogado.getEmail(), codigo);

			String digitado = JOptionPane.showInputDialog(null,
					"Um código foi enviado para: " + usuarioLogado.getEmail() + "\n\nDigite o código recebido:");

			if (digitado == null)
				return; 

			if (codigo.equals(digitado.trim())) {
				String novaSenha = JOptionPane.showInputDialog(null, "Digite a nova senha:");

				if (novaSenha == null || novaSenha.isBlank()) {
					JOptionPane.showMessageDialog(null, "Senha não pode ser vazia!");
					return;
				}

				usuarioLogado.setSenha(novaSenha);
				user.atualizarSenha(usuarioLogado.getId(), novaSenha);
				contaADM.preencherDados(usuarioLogado);
				JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");

			} else {
				JOptionPane.showMessageDialog(null, "Código incorreto! Tente novamente.");
			}

		} catch (MessagingException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao enviar email: " + ex.getMessage());
		}
	}

	private void alterarNome() {
		Usuario usuarioLogado = navegador.getUsuarioLogado();

		String novoNome = JOptionPane.showInputDialog(null, "Digite o novo nome:", usuarioLogado.getNome()); 
		if (novoNome == null)
			return; 

		if (novoNome.isBlank()) {
			JOptionPane.showMessageDialog(null, "Nome não pode ser vazio!");
			return;
		}

		usuarioLogado.setNome(novoNome);
		user.atualizarUsuario(usuarioLogado);
		contaADM.preencherDados(usuarioLogado);
		JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
	}

	private void verificarExcluir() {
		  int confirmacao = JOptionPane.showConfirmDialog(
			        null,
			        "Tem certeza que deseja excluir sua conta?\nEsta ação não pode ser desfeita.", "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
			    );

			    if (confirmacao == JOptionPane.YES_OPTION) {
			        Usuario usuarioLogado = navegador.getUsuarioLogado();
			        user.excluirChamadosDoUsuario(usuarioLogado.getId());
			        user.excluirUsuario(usuarioLogado.getId());           
			        navegador.setUsuarioLogado(null);    
			        JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!");
			        navegador.navegarPara("LOGIN");
			    }

	}

}
