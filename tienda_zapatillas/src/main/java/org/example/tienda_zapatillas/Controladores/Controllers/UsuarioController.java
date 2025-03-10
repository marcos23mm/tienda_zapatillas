package org.example.tienda_zapatillas.Controladores.Controllers;

import jakarta.validation.Valid;
import org.example.tienda_zapatillas.Controladores.Services.UsuarioService;
import org.example.tienda_zapatillas.Modelos.DTOs.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
        String respuesta = usuarioService.crearUsuario(usuario, result);
        if (respuesta.startsWith("Error") || respuesta.startsWith("El correo ya está registrado")) {
            return ResponseEntity.badRequest().body(respuesta);
        }
        return ResponseEntity.ok(respuesta);
    }
}
