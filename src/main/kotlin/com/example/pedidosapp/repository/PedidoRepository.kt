package com.example.pedidosapp.repository

import com.example.pedidosapp.model.Pedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PedidoRepository : JpaRepository<Pedido, Long?> {
    fun findById (id: Long?): Pedido?

}
