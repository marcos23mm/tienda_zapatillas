package org.example.tienda_zapatillas.Modelos.Repositories;

import org.example.tienda_zapatillas.Modelos.DTOs.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public boolean existsByCorreoElectronico(String email);
    Usuario findByCorreoElectronico(String correoElectronico);
}
