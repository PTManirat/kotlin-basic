package com.kotlinbasic.customer.service

import com.kotlinbasic.customer.entity.CustomerEntity
import com.kotlinbasic.customer.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private val customerRepository: CustomerRepository
        ){
    fun listCustomer(): MutableList<CustomerEntity> {
        println("---service--->")
        return customerRepository.findAll()
    }

    fun addCustomer(customer: CustomerEntity): CustomerEntity {
        println("---service add--->")
        return customerRepository.save(customer)
    }

    fun getCustomerByName(customerName: String): List<CustomerEntity> {
        println("---service get customer by name--->")
        return customerRepository.findByFirstName(customerName)
    }

    fun editCustomer(customer: CustomerEntity, customerId: Long): CustomerEntity {
        println("---service edit name--->")
        val getCustomer = customerRepository.findById(customerId)
        if (getCustomer.isPresent) {
            val oldCustomer = getCustomer.get()
            if (customer.firstName != null) {
                oldCustomer.firstName = customer.firstName
            }
            if (customer.lastName != null) {
                oldCustomer.lastName = customer.lastName
            }
            return customerRepository.save(oldCustomer)
        }
        else {
            throw Exception("not found id: $customerId")
        }
    }

    fun getCustomerDetail(customerId: Long): CustomerEntity {
        val customer = customerRepository.findById(customerId)
        if (customer.isPresent) {
            return customer.get()
        }
        throw Exception("not found id: $customerId")
    }

    fun deleteCustomer(customerId: Long) {
        println("---service delete--->")
        return customerRepository.deleteById(customerId)
    }
}