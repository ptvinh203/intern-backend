package com.ptvinh203.internbackend.configuration.auth_config;

import com.ptvinh203.internbackend.service.JwtService;
import com.ptvinh203.internbackend.util.base_model.ApiDataResponse;
import com.ptvinh203.internbackend.util.base_model.ErrorResponse;
import com.ptvinh203.internbackend.util.constant.CommonConstant;
import com.ptvinh203.internbackend.util.constant.ErrorMessageConstant;
import com.ptvinh203.internbackend.util.exception.ForbiddenException;
import com.ptvinh203.internbackend.util.exception.UnauthorizedException;
import com.ptvinh203.internbackend.util.util.CommonUtils;
import com.ptvinh203.internbackend.util.util.ErrorUtils;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtAuthFilterConfig extends OncePerRequestFilter {
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
            @Nonnull HttpServletRequest request,
            @Nonnull HttpServletResponse response,
            @Nonnull FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            final String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader == null || !authorizationHeader.startsWith(CommonConstant.JWT_TYPE)) {
                filterChain.doFilter(request, response);
                return;
            }

            // Get the token from the header
            String token = authorizationHeader.replaceFirst("%s ".formatted(CommonConstant.JWT_TYPE), "");

            // Set new authentication object to the SecurityContextHolder
            UserDetails userDetails = jwtService.getAccountFromToken(token);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, token, userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            filterChain.doFilter(request, response);
        } catch (ForbiddenException | UnauthorizedException ex) {
            CommonUtils.logError(request.getMethod(), request.getRequestURL().toString(), ex.getMessage());
            response.setStatus(ex instanceof UnauthorizedException ? HttpServletResponse.SC_UNAUTHORIZED : HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            ErrorResponse error = ErrorUtils.getExceptionError(ex.getMessage());
            ApiDataResponse apiDataResponse = ApiDataResponse.error(error);
            response
                    .getWriter()
                    .write(Objects.requireNonNull(ErrorUtils.convertToJSONString(apiDataResponse)));
        } catch (Exception ex) {
            CommonUtils.logError(request.getMethod(), request.getRequestURL().toString(), ex.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            ErrorResponse error = new ErrorResponse(ErrorMessageConstant.INTERNAL_SERVER_ERROR, ex.getMessage());
            ApiDataResponse apiDataResponse = ApiDataResponse.error(error);
            response
                    .getWriter()
                    .write(Objects.requireNonNull(ErrorUtils.convertToJSONString(apiDataResponse)));
        }
    }
}
