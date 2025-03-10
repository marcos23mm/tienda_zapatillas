package org.example.tienda_zapatillas.Controladores.Services;

import org.example.tienda_zapatillas.Modelos.DTOs.Usuario;
import org.example.tienda_zapatillas.Modelos.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean autenticarUsuario(String correoElectronico, String contrasena) {
        // Obtener el usuario desde la base de datos
        Usuario usuario = usuarioRepository.findByCorreoElectronico(correoElectronico);

        if (usuario != null) {
            // Verificar que la contraseña coincida con la cifrada
            return passwordService.matches(contrasena, usuario.getContraseña());
        }
        return false;
    }
}