package react.memo.api.jwt.component;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Component;
import react.memo.api.jwt.dto.TokenInfo;

@Component
public class JwtTokenProvider {
  private final SecretKey key;

  public JwtTokenProvider(@Value("${jwt.secret}") String secretKey){
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    this.key = Keys.hmacShaKeyFor(keyBytes);
  }

  public TokenInfo generateToken(Authentication authentication){
    return null;
  }
}