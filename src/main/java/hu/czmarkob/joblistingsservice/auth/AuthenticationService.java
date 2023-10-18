package hu.czmarkob.joblistingsservice.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticationService {

	@Value("${api-key}")
	private String authToken;

	public Authentication getAuthentication(HttpServletRequest request) {
		String apiKey = request.getHeader("x-api-key");

		if (apiKey == null || !apiKey.equals(authToken)) {
			throw new BadCredentialsException("Invalid API Key");
		}

		return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
	}
}
