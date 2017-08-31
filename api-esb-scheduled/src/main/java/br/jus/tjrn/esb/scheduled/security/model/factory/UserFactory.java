package br.jus.tjrn.esb.scheduled.security.model.factory;

import br.jus.tjrn.esb.scheduled.entity.Usuario;
import br.jus.tjrn.esb.scheduled.security.model.security.SecUser;

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
