package com.kotlinbasic.customer.repository

import com.kotlinbasic.customer.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerEntity, Long> {
    fun findByFirstName(firstName: String) : List<CustomerEntity>
}