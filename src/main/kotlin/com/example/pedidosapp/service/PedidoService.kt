package com.example.pedidosapp.service

import com.example.pedidosapp.model.Pedido
import com.example.pedidosapp.repository.ClienteRepository
import com.example.pedidosapp.repository.PedidoRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PedidoService {
    @Autowired
    lateinit var clienteRepository: ClienteRepository
    @Autowired
    lateinit var pedidoRepository: PedidoRepository

    fun list ():List<Pedido>{
        return pedidoRepository.findAll()
    }

    fun save(pedido: Pedido):Pedido{
        try {
            clienteRepository.findById(pedido.clienteId)
                    ?: throw Exception("Id del cliente no encontrado")
            return pedidoRepository.save(pedido)
        }catch (ex : Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update(pedido: Pedido): Pedido {
        try {
            pedidoRepository.findById(pedido.id)
                    ?: throw Exception("ID no existe")

            return pedidoRepository.save(pedido)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(pedido: Pedido): Pedido{
        try{
            val response = pedidoRepository.findById(pedido.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                fechaPedido=pedido.fechaPedido //un atributo del modelo
            }
            return pedidoRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (pedidoId: Long?):Boolean?{
        try{
            val response = pedidoRepository.findById(pedidoId)
                    ?: throw Exception("ID no existe")
            pedidoRepository.deleteById(pedidoId!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (pedidoId:Long?): Pedido?{
        return pedidoRepository.findById(pedidoId)
    }

}