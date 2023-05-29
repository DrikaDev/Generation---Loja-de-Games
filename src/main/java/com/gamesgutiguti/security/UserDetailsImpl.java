package com.gamesgutiguti.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gamesgutiguti.model.Usuario;

public class UserDetailsImpl implements UserDetails{
	
	//indica a versão da classe - se a classe carrega, se é compatível
	//serializar: pegar o valor de cada atributo da sequencia, acrescentar uma versão
	//criar uma serie para poder identificar qual a versão da classe
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private List <GrantedAuthority> authorities;
	
	//criar o construtor:
	public UserDetailsImpl(Usuario user) {
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	//construtor padrão:
	public UserDetailsImpl() {
		
	}
	
	//sobrescrever os metodos da implementação:
	//implementar o granted authorities
	@Override
	public Collection <? extends GrantedAuthority> getAuthorities (){
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return userName;
	}
	
	//metodos sobrescritos no UserDetails:
	
	//indica se o acesso do usuario expirou ou não
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//indica se o usuário está bloqueado daí não pode ser autenticado no sistema.
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//indica se a credencial/senha expirada
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//indica se usuario desabilitado e não pode fazer a autenticação.
	@Override
	public boolean isEnabled() {
		return true;
	}
}
