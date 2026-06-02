package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import jakarta.mail.MessagingException;
import models.Usuario;
import models.UsuarioDAO;
import view.Mensagem;
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
		Usuario usuarioLogado = navegador.getUsuarioLogado(); 
		String codigo = String.valueOf((int) (Math.random() * 900000) + 100000); 

		try {
			EmailService.enviarCodigo(usuarioLogado.getEmail(), codigo);

			String digitado = JOptionPane.showInputDialog(null,
					"Um código foi enviado para: " + usuarioLogado.getEmail() + "\n\nDigite o código recebido:");

			if (digitado == null)
				return; // usuário cancelou

			if (codigo.equals(digitado.trim())) {
				String novaSenha = JOptionPane.showInputDialog(null, "Digite a nova senha:");

				if (novaSenha == null || novaSenha.isBlank()) {
					Mensagem.mostrar("Senha não pode ser vazia!", "Atenção");
					return;
				}

				usuarioLogado.setSenha(novaSenha);
				user.atualizarSenha(usuarioLogado.getId(), novaSenha);
				conta.preencherDados(usuarioLogado);
				Mensagem.mostrar("Senha alterada com sucesso!", "Sucesso");

			} else {
				Mensagem.mostrar("Código incorreto! Tente novamente.", "Erro");
			}

		} catch (MessagingException ex) {
			Mensagem.mostrar("Erro ao enviar email: " + ex.getMessage(), "Erro");
		}
	}

	private void alterarNome() {
		Usuario usuarioLogado = navegador.getUsuarioLogado();

		String novoNome = JOptionPane.showInputDialog(null, "Digite o novo nome:", usuarioLogado.getNome()); 
		if (novoNome == null)
			return; 

		if (novoNome.isBlank()) {
			Mensagem.mostrar("Nome não pode ser vazio!", "Atenção");
			return;
		}

		usuarioLogado.setNome(novoNome);
		user.atualizarUsuario(usuarioLogado);
		conta.preencherDados(usuarioLogado);
		Mensagem.mostrar("Nome alterado com sucesso!", "Sucesso");
	}

	private void verificarExcluir() {

	}

	private void escolherAvatar() {
		TelaEscolhaAvatar tela = new TelaEscolhaAvatar();
		tela.setVisible(true); 

		String avatarEscolhido = tela.getAvatarEscolhido();

		if (avatarEscolhido != null) {
			Usuario usuarioLogado = navegador.getUsuarioLogado();
			usuarioLogado.setFoto(avatarEscolhido);
			user.atualizarFoto(usuarioLogado.getId(), avatarEscolhido);
			conta.atualizarFoto(avatarEscolhido);
			Mensagem.mostrar("Avatar atualizado com sucesso!", "Sucesso");
		}
	}

}
