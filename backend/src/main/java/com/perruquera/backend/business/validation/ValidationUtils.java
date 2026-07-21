package com.perruquera.backend.business.validation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.perruquera.backend.entities.DiaSemana;

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

    public static boolean isValidApellido(String apellido) {
        if (!isNotBlank(apellido)) {
            return false;
        }
        apellido = apellido.trim();

        return apellido.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+([ -][A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$");
    }

    public static boolean isValidTexto(String texto) {
        if (!isNotBlank(texto)) {
            return false;
        }
        texto = texto.trim();

        return texto.length() <= 500;
    }

    public static boolean isValidEmail(String email) {
        if (!isNotBlank(email)) {
            return false;
        }
        email = email.trim();

        return email.matches("^[a-z.+_-]+@[a-z.+_-]+\\.[a-z]{2,}$");
    }

    public static boolean isValidTelefono(String telefono) {
        if (!isNotBlank(telefono)) {
            return false;
        }
        telefono = telefono.trim();
        return telefono.matches("^[6-9][0-9]{8}$");
    }

    public static boolean isValidPassword(String password) {
        if (!isNotBlank(password)) {
            return false;
        }
        password = password.trim();

        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }

    public static boolean isValidFotoUrl(String fotoUrl){

         if (!isNotBlank(fotoUrl)) {
        return false;
    }

    fotoUrl = fotoUrl.trim().toLowerCase();

    return fotoUrl.endsWith(".jpg")
            || fotoUrl.endsWith(".jpeg")
            || fotoUrl.endsWith(".png")
            || fotoUrl.endsWith(".webp");

    }

    // Numeros
    public static boolean isValidPrecio(BigDecimal precio) {
        return precio != null && precio.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isValidDuracion(int duracionEstimada) {
        return duracionEstimada > 0;
    }

    public static boolean isValidPeso(BigDecimal peso){
        return peso  != null && peso.compareTo(BigDecimal.ZERO) > 0;
    }

    // Horas y Fechas
    public static boolean isValidHora(LocalTime hora) {
        return hora != null;
    }
    public static boolean isValidFecha(LocalDate fecha) {
        return fecha != null;
    }

    public static boolean isValidRangoHorario(LocalTime horaApertura, LocalTime horaCierre) {
        return horaApertura != null && horaCierre != null && horaApertura.isBefore(horaCierre);
    }

    public static boolean isValidFechaHora(LocalDateTime fechaHora) {
        return fechaHora != null;
    }

    public static boolean isValidDiaSemana(DiaSemana diaSemana) {
        return diaSemana != null;
    }

    public static boolean isValidFechaNacimiento(LocalDate fechaNacimiento){
        return fechaNacimiento != null && fechaNacimiento.isBefore(LocalDate.now());
    }

    // BOOLEAN
    public static boolean isFalse(Boolean value) {
        return Boolean.FALSE.equals(value);
    }

}
