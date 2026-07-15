package com.perruquera.backend.business.validation;

public final class ValidationUtils {

    private ValidationUtils() {
    }

    // String
    public static boolean isNotBlank(String nombre) {
        return nombre != null && !nombre.isBlank();
    }

    public static boolean isValidNombre(String nombre) {
        if (!isNotBlank(nombre)) {
            return false;
        }
        nombre = nombre.trim();
        return nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{2,}$");

    }

    public static boolean isValidTexto(String texto) {
        if (!isNotBlank(texto)) {
            return false;
        }
        texto = texto.trim();

        return texto.length() <= 500;
    }

    // Email
    public static boolean isValidEmail(String email) {
        if (!isNotBlank(email)) {
            return false;
        }
        email = email.trim();

        return email.matches("^[a-z.+_-]+@[a-z.+_-]+\\.[a-z]{2,}$");
    }

    //telefono
    public static boolean isValidTelefono(String telefono){
        if (!isNotBlank(telefono)) {
            return false;
        }
        telefono = telefono.trim();
        return telefono.matches("^[6-9][0-9]{8}$");
    }
}
