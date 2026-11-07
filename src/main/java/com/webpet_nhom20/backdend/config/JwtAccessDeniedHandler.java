package com.webpet_nhom20.backdend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

// Chuẩn hóa api response khi không đủ quyền truy cập (HTTP 403 Forbidden)
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        response.setStatus(errorCode.getStatusCode().value());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        ApiResponse<?> apiResponse = ApiResponse.<String>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .success(false)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();

        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
        response.getWriter().flush();
    }
}
