package com.app.soap.ApiRestToSoapPokemon.webService.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
/**
 * HttpServlest class.
 * @autor jjpc
 */
public class HttpServlest {

    /** HttpServletRequest property */
    private final HttpServletRequest httpServletRequest;

    /**
     * HttpServlest constructor
     * @param httpServletRequest
     */
    public HttpServlest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * getIP method.
     * @return String ip
     */
    public String getIP(){
        String ipClient=httpServletRequest.getRemoteAddr();

        String remoteAddr = "";

        if (httpServletRequest != null) {
            remoteAddr = httpServletRequest.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = httpServletRequest.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}
