package com.onlineShoping.demo.config.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.onlineShoping.demo.config.JWTTokenUtil;
import com.onlineShoping.demo.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	UserService userService;

	@Autowired
	JWTTokenUtil jwtTokenUtil;

	private final String REQUEST_HEADER_AUTHORIZATION = "Authorization";
	private final String BEARER_TOKEN_NAME = "Bearer ";

	public JwtRequestFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token = request.getHeader(REQUEST_HEADER_AUTHORIZATION);

		if (StringUtils.hasText(token)
				&& StringUtils.substringMatch(token, 0, BEARER_TOKEN_NAME)) {
			String JWTtoken = token.substring(BEARER_TOKEN_NAME.length());
			String userName = "";
			try {
				userName = jwtTokenUtil.getUsernameFromToken(JWTtoken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}

			if (StringUtils.hasText(userName) && SecurityContextHolder
					.getContext().getAuthentication() == null) {
				UserDetails userDetails = userService
						.loadUserByUsername(userName);
				// if token is valid configure Spring Security to manually set
				// authentication
				if (jwtTokenUtil.validateToken(JWTtoken, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource()
									.buildDetails(request));
					// After setting the Authentication in the context, we
					// specify
					// that the current user is authenticated. So it passes the
					// Spring Security Configurations successfully.
					SecurityContextHolder.getContext().setAuthentication(
							usernamePasswordAuthenticationToken);
				}
			}

		}
		filterChain.doFilter(request, response);

	}

}
