package controller;

import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class LoginController {
	
	private Database db;
	
	// Construtor da classe
	public LoginController () {
		db = new Database();
	}
	
	public void FazLogin (String Email, String Senha) {
		List<Usuario> retornoDoBanco = db.executarSQL("SELECT * FROM Usuarios where email = '" + Email + "' and Senha = '" + Senha + "'");
		// Se o retorno do banco não for vazio
		if(!retornoDoBanco.isEmpty()) {
			System.out.println(retornoDoBanco);
		}
		else {
			System.out.println("Usuario não encontrado");
		}
	}
	
	public void CriaUsuario(String Email, String Senha, String Nome) {
		System.out.println("Criando Usuário");
	}

}
