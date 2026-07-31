package com.perruquera.backend.business.service.auth;

import com.perruquera.backend.adapters.in.auth.api.LoginRequestDTO;

public interface IAuthService {

    /**
     * Autentica un usuario mediante su correo electrónico y contraseña.
     *
     * @param request datos de acceso del usuario.
     * @return token JWT generado tras una autenticación correcta.
     */
    String login(LoginRequestDTO request);

}
