package org.example.tienda_zapatillas.Modelos.DTOs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference("usuario-carrito")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "producto_id", nullable = false)
    @JsonBackReference("producto-carrito")
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public org.example.tienda_zapatillas.Modelos.DTOs.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(org.example.tienda_zapatillas.Modelos.DTOs.Usuario usuario) {
        this.usuario = usuario;
    }

    public org.example.tienda_zapatillas.Modelos.DTOs.Producto getProducto() {
        return producto;
    }

    public void setProducto(org.example.tienda_zapatillas.Modelos.DTOs.Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
