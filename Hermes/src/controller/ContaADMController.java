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
		
		this.contaADM.irInicioADM(e -> {
			navegador.navegarPara("INICIO ADMIN");
		});

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

			String digitado = MensagemInput.mostrarInput(
					"Um código foi enviado para: " + usuarioLogado.getEmail() + "Digite o código recebido:", "Atenção");

			if (digitado == null)
				return; 

			if (codigo.equals(digitado.trim())) {
				String novaSenha = MensagemInput.mostrarInput(null, "Digite a nova senha:");

				if (novaSenha == null || novaSenha.isBlank()) {
					Mensagem.mostrar("Senha não pode ser vazia!", "Atenção");
					return;
				}

				usuarioLogado.setSenha(novaSenha);
				user.atualizarSenha(usuarioLogado.getId(), novaSenha);
				contaADM.preencherDados(usuarioLogado);
				Mensagem.mostrar("Senha alterada com sucesso!", "Sucesso");

			} else {
				Mensagem.mostrar("Código incorreto! Tente novamente.","Erro");
			}

		} catch (MessagingException ex) {
		    Mensagem.mostrar("Erro ao enviar email: " + ex.getMessage(), "Erro");
		}
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
	            contaADM.preencherDados(usuarioLogado);
	            Mensagem.mostrar("Nome alterado com sucesso!", "Sucesso");
	        });
	    }).start();
	}

	private void verificarExcluir() {
	    MensagemSN.mostrarSN(
	        "Tem certeza que deseja excluir sua conta?\nEsta ação não pode ser desfeita.", "Atenção",
	        e -> {
	            Usuario usuarioLogado = navegador.getUsuarioLogado();
	            user.excluirChamadosDoUsuario(usuarioLogado.getId());
	            user.excluirUsuario(usuarioLogado.getId());
	            navegador.setUsuarioLogado(null);
	            JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!");
	            navegador.navegarPara("LOGIN");
	        },
	        e -> {
	           
	        }
	    );
	}

}
