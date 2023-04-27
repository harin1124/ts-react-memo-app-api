package react.memo.api.config.jwt;

public interface JwtProperties {
  String SECRET = "";
  int EXPIRATION_TIME = 864000000; // 10일 (1/1000초)
  String TOKEN_PREFIX = "Bearer ";
  String HEADER_STRING = "Authorization";
}