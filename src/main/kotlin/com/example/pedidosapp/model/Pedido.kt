package com.example.pedidosapp.model

import jakarta.persistence.*
import java.text.DecimalFormat
import java.util.Date

@Entity
@Table(name = "pedido")
class Pedido {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column (name="fecha_pedido")
    var fechaPedido: Date? = null
    var total: Int? = null
    @Column (name="cliente_id")
    var clienteId: Long? = null
}