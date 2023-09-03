package com.project.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.RequestLoginTokenDto;
import com.project.demo.model.ResponseLoginTokenDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginTokenControllerApi {

	Logger logger = Logger.getLogger(LoginTokenControllerApi.class.getName());
	
	public final static String ADMIN = "admin";

	@PostMapping("api/login")
	public ResponseLoginTokenDto login(@RequestBody RequestLoginTokenDto rq) {

		logger.info("Entre a generar token");
		ResponseLoginTokenDto response = new ResponseLoginTokenDto();
		if(!rq.getUser().equals(ADMIN) || !rq.getPassword().equals(ADMIN)) {
			response.setUser(rq.getUser());
			response.setToken(null);
			response.setMessage("Datos invalidos para generar token");
			return response;
		}
		String token = getJWTToken(rq.getUser());
		
		response.setUser(rq.getUser());
		response.setToken(token);
		response.setMessage("Token Generado");
		return response;

	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}


}