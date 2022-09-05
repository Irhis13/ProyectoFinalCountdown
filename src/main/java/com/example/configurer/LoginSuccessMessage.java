package com.example.configurer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginSuccessMessage extends SimpleUrlAuthenticationSuccessHandler{
    
    // @Override
    // public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
    //     Authentication authentication) throws IOException, ServletException {

    //     SessionFlashMapManager fManager = new SessionFlashMapManager();
    //     FlashMap fMap = new FlashMap();

    //     fMap.put("succes", "Bienvenide, la sesión ha sido iniciada con éxito");
    //     fManager.saveOutputFlashMap(fMap, request, response);

    //     super.onAuthenticationSuccess(request, response, authentication);
    // }
}
