package br.com.lareira.api.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lareira.api.model.Permissao;
import br.com.lareira.api.model.Usuario;
import br.com.lareira.api.model.UsuarioGrupo;
import br.com.lareira.api.repository.UsuarioRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
		Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));

		return new UsuarioSistema(usuario, getPermissoes(usuario));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		List<UsuarioGrupo> lista = usuario.getUsuarioGrupoList();
		System.out.println(lista);

		for (Iterator<UsuarioGrupo> iterator = lista.iterator(); iterator.hasNext();) {
			UsuarioGrupo usuarioGrupo = iterator.next();

			List<Permissao> permissoes = usuarioGrupo.getGrupo().getPermissaoList();

			for (Iterator<Permissao> iterator2 = permissoes.iterator(); iterator2.hasNext();) {
				Permissao permissao = iterator2.next();

				if (permissao.getCanView()) {
					authorities.add(new SimpleGrantedAuthority(permissao.getEntidade().getNomeTabelaBanco().toUpperCase() + "_VIEW"));
				}
				
				if (permissao.getCanInsert()) {
					authorities.add(new SimpleGrantedAuthority(permissao.getEntidade().getNomeTabelaBanco().toUpperCase() + "_INSERT"));
				} 
				
				if (permissao.getCanUpdate()) {
					authorities.add(new SimpleGrantedAuthority(permissao.getEntidade().getNomeTabelaBanco().toUpperCase() + "_UPDATE"));
				} 
				
				if (permissao.getCanDelete()) {
					authorities.add(new SimpleGrantedAuthority(permissao.getEntidade().getNomeTabelaBanco().toUpperCase() + "_DELETE"));
				}
				
				System.out.println(permissao.toString());
			}
		}
		
		System.out.println(authorities);

		return authorities;
	}

}