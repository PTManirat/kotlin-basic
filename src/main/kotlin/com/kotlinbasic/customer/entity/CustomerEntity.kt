package com.kotlinbasic.customer.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue
import javax.persistence.Table

@Entity
@Table(name = "customer")
open class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long = 0

    @Column(name = "first_name")
    open var firstName: String? = null

    @Column(name = "last_name")
    open var lastName: String? = null

    override fun toString(): String {
        return String.format(
            "Customer[id=%d, firstName='%s', lastName='%s']",
            id, firstName, lastName
        )
    }
}