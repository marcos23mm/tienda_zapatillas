package org.example.tienda_zapatillas.Modelos.DTOs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "correo_electronico", nullable = false, length = 100)
    @Email(message = "Correo ya registrado")
    private String correoElectronico;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @ColumnDefault("'normal'")
    @NotNull
    @Lob
    @Column(name = "tipo_usuario")
    private String tipoUsuario = "normal";

    @Size(max = 255)
    @NotNull
    @Column(name = "`contraseña`", nullable = false)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,24}$",
            message = "La contraseña debe contener al menos una mayúscula, una minúscula, un número, un carácter especial y tener una longitud de entre 8 y 24 caracteres.")
    @Size(min = 8, max = 24, message = "La longitud de la contraseña debe ser entre 8 y 24 caracteres.")
    private String contraseña;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference("usuario-carrito")
    private Set<Carrito> carritos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference("usuario-pedido")
    private Set<Pedido> pedidos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Set<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(Set<Carrito> carritos) {
        this.carritos = carritos;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}