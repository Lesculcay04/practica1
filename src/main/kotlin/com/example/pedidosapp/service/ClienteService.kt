package com.example.pedidosapp.service

import com.example.pedidosapp.model.Cliente
import com.example.pedidosapp.repository.ClienteRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ClienteService {
    @Autowired
    lateinit var clienteRepository: ClienteRepository

    fun list ():List<Cliente>{
        return clienteRepository.findAll()
    }

    fun save(cliente: Cliente): Cliente {
        try{
            cliente.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return clienteRepository.save(cliente)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(cliente: Cliente): Cliente{
        try {
            clienteRepository.findById(cliente.id)
                    ?: throw Exception("ID no existe")

            return clienteRepository.save(cliente)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(cliente: Cliente): Cliente{
        try{
            val response = clienteRepository.findById(cliente.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                nombre=cliente.nombre
            }
            return clienteRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = clienteRepository.findById(id)
                    ?: throw Exception("ID no existe")
            clienteRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Cliente?{
        return clienteRepository.findById(id)
    }

}