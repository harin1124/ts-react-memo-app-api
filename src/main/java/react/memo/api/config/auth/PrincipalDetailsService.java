package react.memo.api.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import react.memo.api.dto.Users;
import react.memo.api.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    //System.out.println("PrincipalDetailsService : 진입");
    Users user = userRepository.findByUserId(userId);
    //System.out.println("[PrincipalDetailsService] User = "+user);

    return new PrincipalDetails(user);
  }
}
