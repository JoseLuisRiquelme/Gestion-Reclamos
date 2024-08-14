package cl.praxis.GestionReclamos.model.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password123"; // Cambia esto por la contraseña que quieres cifrar
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Encoded Password: " + encodedPassword);
    }
}
