package com.universidad.tarea3.seguridad;

public class InputValidator {

    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_.]{4,20}$";

    public static boolean usernameValido(String username) {
        return username != null && username.matches(USERNAME_REGEX);
    }
}

