package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import jakarta.mail.MessagingException;
import models.Usuario;
import models.UsuarioDAO;
import view.TelaConta;
import view.TelaEscolhaAvatar;

public class ContaController {

	private TelaConta conta;
	private UsuarioDAO user;
	private Navegador navegador;

	public ContaController(TelaConta conta, UsuarioDAO user, Navegador navegador, Menu menu) {
		super();
		this.conta = conta;
		this.user = user;
		this.navegador = navegador;

		this.conta.excluirConta(e -> {
			verificarExcluir();

		});
		this.conta.editarSenha(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {

				alterarSenha();
			}

		});
		this.conta.editarNome(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				alterarNome();
			}
		});
		this.conta.escolherFoto(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				escolherAvatar();
			}
		});

	}

	public void preencherDados() {
		conta.preencherDados(navegador.getUsuarioLogado());
	}

	private void alterarSenha() {
		Usuario usuarioLogado = navegador.getUsuarioLogado(); // <- pega do navegador
		String codigo = String.valueOf((int) (Math.random() * 900000) + 100000); // 6 dígitos

		try {
			EmailService.enviarCodigo(usuarioLogado.getEmail(), codigo);

			String digitado = JOptionPane.showInputDialog(null,
					"Um código foi enviado para: " + usuarioLogado.getEmail() + "\n\nDigite o código recebido:");

			if (digitado == null)
				return; // usuário cancelou

			if (codigo.equals(digitado.trim())) {
				String novaSenha = JOptionPane.showInputDialog(null, "Digite a nova senha:");

				if (novaSenha == null || novaSenha.isBlank()) {
					JOptionPane.showMessageDialog(null, "Senha não pode ser vazia!");
					return;
				}

				usuarioLogado.setSenha(novaSenha);
				user.atualizarSenha(usuarioLogado.getId(), novaSenha);
				conta.preencherDados(usuarioLogado);
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
			return; // cancelou

		if (novoNome.isBlank()) {
			JOptionPane.showMessageDialog(null, "Nome não pode ser vazio!");
			return;
		}

		usuarioLogado.setNome(novoNome);
		user.atualizarUsuario(usuarioLogado);
		conta.preencherDados(usuarioLogado);
		JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
	}

	private void verificarExcluir() {

	}

	private void escolherAvatar() {
		TelaEscolhaAvatar tela = new TelaEscolhaAvatar();
		tela.setVisible(true); // bloqueia até o usuário escolher

		String avatarEscolhido = tela.getAvatarEscolhido();

		if (avatarEscolhido != null) {
			Usuario usuarioLogado = navegador.getUsuarioLogado();
			usuarioLogado.setFoto(avatarEscolhido);
			user.atualizarFoto(usuarioLogado.getId(), avatarEscolhido);
			conta.atualizarFoto(avatarEscolhido);
			JOptionPane.showMessageDialog(null, "Avatar atualizado com sucesso!");
		}
	}

}
