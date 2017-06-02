package br.unp.web.revisao_de_acessos.security.model.factory;

import br.unp.web.revisao_de_acessos.entity.Usuario;
import br.unp.web.revisao_de_acessos.security.model.security.SecUser;

import org.springframework.security.core.authority.AuthorityUtils;

public class UserFactory {

  public static SecUser create(Usuario user) {
    return new SecUser(
      user.getId(),
      user.getUsername(),
      user.getPassword(),
      user.getEmail(),
      user.getLastPasswordReset(),
      AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities())
    );
    
  }

}
