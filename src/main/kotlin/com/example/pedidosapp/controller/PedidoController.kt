package com.example.pedidosapp.controller

import com.example.pedidosapp.model.Cliente
import com.example.pedidosapp.model.Pedido
import com.example.pedidosapp.service.ClienteService
import com.example.pedidosapp.service.PedidoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pedido")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class PedidoController {
    @Autowired
    lateinit var pedidoService: PedidoService

    @GetMapping
    fun list(): List<Pedido> {
        return pedidoService.list()
    }

    @PostMapping
    fun save(@RequestBody pedido: Pedido): ResponseEntity<Pedido> {
        return ResponseEntity(pedidoService.save(pedido), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody pedido: Pedido): ResponseEntity<Pedido> {
        return ResponseEntity(pedidoService.update(pedido), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody pedido: Pedido): ResponseEntity<Pedido> {
        return ResponseEntity(pedidoService.updateName(pedido), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean? {
        return pedidoService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(pedidoService.listById(id), HttpStatus.OK)

    }
}