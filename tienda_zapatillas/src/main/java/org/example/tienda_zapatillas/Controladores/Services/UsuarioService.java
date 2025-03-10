package org.example.tienda_zapatillas.Controladores.Services;

import org.example.tienda_zapatillas.Modelos.DTOs.Usuario;
import org.example.tienda_zapatillas.Modelos.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordService passwordService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordService = passwordService;
    }

    public String crearUsuario(Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "Error en la validación: " + result.getAllErrors();
        }

        if (usuarioRepository.existsByCorreoElectronico(usuario.getCorreoElectronico())) {
            return "El correo ya está registrado";
        }

        String contrasenaCifrada = passwordService.encodePassword(usuario.getContraseña());
        usuario.setContraseña(contrasenaCifrada);

        usuarioRepository.save(usuario);
        return "Usuario creado correctamente";
    }

}
