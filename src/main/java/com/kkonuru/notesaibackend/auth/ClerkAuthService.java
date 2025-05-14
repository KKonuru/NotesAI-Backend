package com.kkonuru.notesaibackend.auth;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetEmailAddressResponse;
import com.clerk.backend_api.models.operations.VerifyClientRequestBody;
import com.clerk.backend_api.models.operations.VerifyClientResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.clerk.backend_api.helpers.jwks.AuthenticateRequest;
import com.clerk.backend_api.helpers.jwks.AuthenticateRequestOptions;
import com.clerk.backend_api.helpers.jwks.RequestState;

import java.util.*;

@Service
public class ClerkAuthService {

    @Value("${clerk.secret.key}")
    private String clerkSecretKey;
    public String getUserIdFromToken(HttpServletRequest request) {

        Map<String, List<String>> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, Arrays.asList(request.getHeader(headerName)));
        }
        RequestState requestState = AuthenticateRequest.authenticateRequest(
                headers,
                AuthenticateRequestOptions
                        .secretKey(clerkSecretKey)
                        .build()
        );

        if (!requestState.isSignedIn()) {
            throw new RuntimeException("Invalid User");
        }

        if(requestState.claims().isPresent()) {
            return requestState.claims().get().get("user_id",String.class);
        }
        throw new RuntimeException("Invalid User");
    }


}
