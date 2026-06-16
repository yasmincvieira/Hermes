package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.Usuario;
import models.UsuarioDAO;
import view.MenuContraidoTeste;
import view.MenuExpandidoAdm;
import view.MenuExpandidoTeste;
import view.Janela;
import view.MensagemSN;

public class Menu {

    private MenuExpandidoTeste mnExp;
    private MenuExpandidoAdm mnExpAdm;
    private MenuContraidoTeste mnCont;
    private JPanel menuAtual;
    private Janela janela;
    private Navegador navegador;
    private Usuario usuarioLogado;
    private UsuarioDAO user;

    public Menu(Janela janela, MenuExpandidoTeste mnExp, MenuContraidoTeste mnCont, MenuExpandidoAdm mnExpAdm) {
        this.janela = janela;
        this.mnExp = mnExp;
        this.mnExpAdm = mnExpAdm;
        this.mnCont = mnCont;
        menuAtual = mnCont;
        janela.mudarMenu(menuAtual);

  
        this.mnExp.mostrarMenuContraido(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarPanelCont();
            }
        });
        //botôes menu
        
        this.mnExp.sair(e -> dispose());
        this.mnExpAdm.sair(e -> dispose());

       
        this.mnExp.irHistorico(e -> {
            if (navegador != null)
                navegador.navegarPara("HISTORICO");
        });
        
        this.mnExp.irNovoChamado(e -> {
            if (navegador != null)
                navegador.navegarPara("CHAMADO");
        });
        
        this.mnExpAdm.irHistorico(e -> {
            if (navegador != null)
                navegador.navegarPara("HISTORICO");
        });

        this.mnExp.irInicio(e -> {
            if (navegador != null)
                irInicio();
        });
        this.mnExpAdm.irInicioADM(e -> {
            if (navegador != null)
                irInicio();
        });
        
      
        this.mnExp.irPerfil(e -> {
            if (navegador != null)
                navegador.navegarPara("PERFIL");
        });
        
        this.mnExpAdm.irPerfil(e -> {
            if (navegador != null)
                navegador.navegarPara("PERFIL ADM");
        });

        this.mnExpAdm.irTabela(e -> {
            if (navegador != null)
                navegador.navegarPara("TABELA");
        });

        this.mnExpAdm.irNovosChamados(e -> {
            if (navegador != null)
                navegador.navegarPara("NOVOS_CHAMADOS");
        });
        
        
        
        
        
        
        


      		this.mnCont.mostrarMenuExpandido(new MouseAdapter() {

      			@Override

      			public void mouseClicked(MouseEvent e) {

      				mostrarPanelExp();

      			}

      			public void iniciarMenu() {
      				menuAtual = mnCont;
      				janela.mudarMenu(menuAtual);
      			}

      		});

      	
        
        
    }
    //identifica se o usuário é ADM ou não
    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
        configurarMenuExpandido(); 
    }

 
    private void configurarMenuExpandido() {
        if (this.usuarioLogado != null && this.usuarioLogado.isAdmin()) {
            this.mnCont.mostrarMenuExpandidoAdm(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mostrarPanelExpAdm(); // abre o menu ADM
                }
            });
        } else {
            this.mnCont.mostrarMenuExpandido(new MouseAdapter() {
                //@Override
                public void mouseClicked(MouseEvent e) {
                    mostrarPanelExp(); // abre o menu comum
                }
            });
        }
    }

    
    

    private void irInicio() {
        navegador.setUsuarioLogado(usuarioLogado);
        if (this.usuarioLogado.isAdmin()) {
            navegador.navegarPara("INICIO ADMIN");
        } else {
            navegador.navegarPara("INICIO");
        }
    }

    public void setNavegador(Navegador navegador) {
        this.navegador = navegador;
    }

    public void mostrarPanelCont() {
        menuAtual = mnCont;
        janela.mudarMenu(menuAtual);
    }

    public void mostrarPanelExpAdm() {
        menuAtual = mnExpAdm;
        janela.mudarMenu(menuAtual);
    }

    public void mostrarPanelExp() {
        menuAtual = mnExp;
        janela.mudarMenu(menuAtual);
    }

    public void removerMenu() {
        janela.getPanelMenu().removeAll();
        janela.revalidate();
        janela.repaint();
    }

	

	private void irPerfil() {
		
		navegador.setUsuarioLogado(usuarioLogado);
		if(this.usuarioLogado.isAdmin()) {
			navegador.navegarPara("PERFIL ADM");
		} else {
			navegador.navegarPara("PERFIL");
		}
		
	}

//	private void irInicio() {
//		navegador.setUsuarioLogado(usuarioLogado);
//
//		if (this.usuarioLogado.isAdmin()) {
//			navegador.navegarPara("INICIO ADMIN");
//		} else {
//			navegador.navegarPara("INICIO");
//		}
//
//	}
	
//	public void setUsuarioLogado(Usuario usuarios) {
//	    this.usuarioLogado = usuarios;
//	}
//
//	public void setNavegador(Navegador navegador) {
//		this.navegador = navegador;
//	}

	private void dispose() {
	    MensagemSN.mostrarSN(
	        "Deseja realmente sair?",
	        "Confirmar Ação",
	        sim -> System.exit(0),
	        nao -> {}
	    );
	}

//	public void mostrarPanelCont() {
//
//		menuAtual = mnCont;
//
//		janela.mudarMenu(menuAtual);
//
//	}
//
//	public void mostrarPanelExp() {
//
//		menuAtual = mnExp;
//
//		janela.mudarMenu(menuAtual);
//
//	}
//
//	public void removerMenu() {
//
//		janela.getPanelMenu().removeAll();
//
//		janela.revalidate();
//
//		janela.repaint();
//
//	}

//	public void iniciar() {
//
//		if (janela.getPanelAtual().equals("LOGIN") || janela.getPanelAtual().equals("CADASTRO")
//				|| janela.getPanelAtual().equals("INICIO")) {
//			janela.setVisible(true);
//			removerMenu();
//
//		} else {
//
//			janela.setVisible(true);
//
//			menuAtual = mnCont;
//
//			janela.mudarMenu(menuAtual);
//
//		}
//	}
	public void atualizarFotoMenu(String avatarEscolhido) {
	   
	    if (this.mnExp != null) {
	        this.mnExp.atualizarFotoMenu(avatarEscolhido);
	    }
	    
	    if (this.mnCont != null) {
	        this.mnCont.atualizarFotoMenu(avatarEscolhido);
	    }
	}


    public void iniciar() {
        if (janela.getPanelAtual().equals("LOGIN") || janela.getPanelAtual().equals("CADASTRO")
                || janela.getPanelAtual().equals("INICIO")) {
            janela.setVisible(true);
            removerMenu();
        } else {
            janela.setVisible(true);
            menuAtual = mnCont;
            janela.mudarMenu(menuAtual);
        }
    }
}
