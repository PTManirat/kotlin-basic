package com.kotlinbasic.customer.controller

import com.kotlinbasic.customer.entity.CustomerEntity
import com.kotlinbasic.customer.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")

class CustomerController {
    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping(
        value = ["/customers"],
    )
    fun listCustomer(): MutableList<CustomerEntity> {
        println("hello world1")
        return customerService.listCustomer()
    }

    @GetMapping(
        value = ["/customers/{customerId}"],
    )
    fun listCustomer(
        @PathVariable customerId: Long
    ): CustomerEntity {
        println("hello world2")
        return customerService.getCustomerDetail(customerId)
    }

    @PostMapping(
        value = ["/customers"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun addCustomer(
        @RequestBody customerEntity: CustomerEntity
    ): CustomerEntity {
        println("hello world3")
        return customerService.addCustomer(customerEntity)
    }

    @GetMapping(
        value = ["/customers/{customerName}/name"],
    )
    fun getCustomerByName(
        @PathVariable customerName: String
    ): List<CustomerEntity> {
        println("hello world4")
        return customerService.getCustomerByName(customerName)
    }

    @PatchMapping(
        value = ["/customers/{customerId}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun editCustomer(
        @RequestBody customerEntity: CustomerEntity,
        @PathVariable customerId: Long
    ): CustomerEntity {
        println("hello world5")
        return customerService.editCustomer(customerEntity, customerId)
    }

    @DeleteMapping(
        value = ["/customers/{customerId}"],
    )
    fun deleteCustomer(
        @PathVariable customerId: Long
    ) {
        println("hello world6")
        return customerService.deleteCustomer(customerId)
    }
}