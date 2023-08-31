package react.memo.api.config.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import react.memo.api.user.dto.Users;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {
  private Users user;

  public PrincipalDetails(Users user) {
    this.user = user;
  }

  public Users getUser() {
    return user;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUserId();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    user.getRoleList().forEach(r -> {
      authorities.add(() -> r);
    });
    return authorities;
  }
}