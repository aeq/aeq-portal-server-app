package com.aeq.portal.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aeq.portal.exception.ExpiredJwtTokenException;
import com.aeq.portal.exception.GlobalExceptionHandler;
import com.aeq.portal.security.service.CustomUserDetailsService;
import com.aeq.portal.util.JwtTokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

/**
 * @author abhisheknair
 *
 * @Desc JWT Spring Web Filter to validate the token and handle Exceptions
 */

public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	GlobalExceptionHandler exceptionHandler;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		String jwtToken = null;
		String username = null;

		try {

			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

				jwtToken = requestTokenHeader.substring(7);
				
				// Get username from token subject
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);

			}

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UserDetails userDetails = userDetailsService.loadUserByUsername(username);

				// Validate username from jwt token
				if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
							null, userDetails.getAuthorities());

					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authToken);

				}

			}

			filterChain.doFilter(request, response);

		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Unable to get JWT token");
		} catch (MalformedJwtException e) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.getWriter().write(convertObjectToJson(exceptionHandler
					.handleExpiredJwtTokenException(new ExpiredJwtTokenException("Malformed Jwt Token"), request)));
		} catch (ExpiredJwtException e) {

			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.getWriter().write(convertObjectToJson(exceptionHandler
					.handleExpiredJwtTokenException(new ExpiredJwtTokenException("Jwt token has expired"), request)));
		}

	}

	private String convertObjectToJson(Object object) throws JsonProcessingException {
		if (object == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

}
