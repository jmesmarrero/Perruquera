package com.perruquera.backend.business.service.auth;

import com.perruquera.backend.entities.Usuario;

public interface IJwtService {

    /**
     * Funcion para generar un Token
     * @param Usuario Recibe un usuario
     * @return parametro String Token
     */
    public String generateToken(Usuario Usuario);

    /**
     * Funcion para saber de quien es el token
     * @param token token a recibir
     * @return parametro email de la persona del token
     */
    public String extractEmail(String token);

    /**
     * Funcion para comprobar si el token es valido
     * @param token token que se construyó
     * @param usuario usuario que representa en token
     * @return true si es token valido o false lo contrario
     */
    public boolean isTokenValid(String token, Usuario usuario);

}
