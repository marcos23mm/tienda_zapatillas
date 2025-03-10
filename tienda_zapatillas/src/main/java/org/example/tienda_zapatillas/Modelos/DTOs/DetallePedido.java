package org.example.tienda_zapatillas.Modelos.DTOs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonBackReference("pedido-detalle") // Debe coincidir con el de Pedido
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "producto_id", nullable = false)
    @JsonBackReference("producto-detalle") // Nuevo identificador
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public org.example.tienda_zapatillas.Modelos.DTOs.Pedido getPedido() {
        return pedido;
    }

    public void setPedido(org.example.tienda_zapatillas.Modelos.DTOs.Pedido pedido) {
        this.pedido = pedido;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

}