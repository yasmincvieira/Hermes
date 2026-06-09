package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import jakarta.mail.MessagingException;
import models.Usuario;
import models.UsuarioDAO;
import view.Mensagem;
import view.MensagemInput;
import view.MensagemSN;
import view.TelaConta;
import view.TelaEscolhaAvatar;

public class ContaController {

	private TelaConta conta;
	private UsuarioDAO user;
	private Navegador navegador;
	private Menu menu;

	public ContaController(TelaConta conta, UsuarioDAO user, Navegador navegador, Menu menu) {
		super();
		this.conta = conta;
		this.user = user;
		this.navegador = navegador;
		this.menu = menu;

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
		new Thread(() -> {
			Usuario usuarioLogado = navegador.getUsuarioLogado();
			String codigo = String.valueOf((int) (Math.random() * 900000) + 100000);

			try {
				EmailService.enviarCodigo(usuarioLogado.getEmail(), codigo);

				String digitado = MensagemInput.mostrarInput(
						"Um código foi enviado para: " + usuarioLogado.getEmail() + "\nDigite o código recebido:",
						"Atenção");

				if (digitado == null)
					return;

				if (codigo.equals(digitado.trim())) {
					String novaSenha = MensagemInput.mostrarInput("Digite a nova senha:", "Alterar senha");

					if (novaSenha == null || novaSenha.isBlank()) {
						SwingUtilities.invokeLater(() -> Mensagem.mostrar("Senha não pode ser vazia!", "Atenção"));
						return;
					}

					usuarioLogado.setSenha(novaSenha);
					user.atualizarSenha(usuarioLogado.getId(), novaSenha);
					conta.preencherDados(usuarioLogado);
					Mensagem.mostrar("Senha alterada com sucesso!", "Sucesso");

				} else {
					SwingUtilities.invokeLater(() -> Mensagem.mostrar("Código incorreto! Tente novamente.", "Erro"));
				}

			} catch (MessagingException ex) {
				SwingUtilities.invokeLater(() -> Mensagem.mostrar("Erro ao enviar email: " + ex.getMessage(), "Erro"));
			}
		}).start();
	}

	private void alterarNome() {
	    new Thread(() -> {
	        Usuario usuarioLogado = navegador.getUsuarioLogado();
	        String novoNome = MensagemInput.mostrarInput("Digite o novo nome:", "Alterar nome");
	        
	        if (novoNome == null) return;
	        
	        if (novoNome.isBlank()) {
	            SwingUtilities.invokeLater(() -> Mensagem.mostrar("Nome não pode ser vazio!", "Atenção"));
	            return;
	        }
	        
	        usuarioLogado.setNome(novoNome);
	        user.atualizarUsuario(usuarioLogado);
	        SwingUtilities.invokeLater(() -> {
	            conta.preencherDados(usuarioLogado);
	            Mensagem.mostrar("Nome alterado com sucesso!", "Sucesso");
	        });
	    }).start();
	}

	private void verificarExcluir() {
		MensagemSN.mostrarSN("Tem certeza que deseja excluir sua conta?\nEsta ação não pode ser desfeita.", "Atenção",
				e -> {
					Usuario usuarioLogado = navegador.getUsuarioLogado();
					user.excluirChamadosDoUsuario(usuarioLogado.getId());
					user.excluirUsuario(usuarioLogado.getId());
					navegador.setUsuarioLogado(null);
					JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!");
					navegador.navegarPara("LOGIN");
				}, e -> {

				});
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

			if (menu != null) {
				menu.atualizarFotoMenu(avatarEscolhido);
			}

			Mensagem.mostrar("Avatar atualizado com sucesso!", "Sucesso");
		}
	}

	public void atualizarContagem() {
		int total = user.contarChamadosPorUsuario(navegador.getUsuarioLogado().getId());
		conta.atualizarQntdChamado(total);
	}

}