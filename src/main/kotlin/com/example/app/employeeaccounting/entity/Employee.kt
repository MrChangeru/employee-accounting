package com.example.app.employeeaccounting.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank(message = "Имя не может быть пустым")
    @field:Size(max = 50, message = "Имя не должно превышать 50 символов")
    var firstName: String,

    @field:NotBlank(message = "Фамилия не может быть пустой")
    @field:Size(max = 50, message = "Фамилия не должна превышать 50 символов")
    var lastName: String,

    @field:NotBlank(message = "Должность не может быть пустой")
    @field:Size(max = 100, message = "Должность не должна превышать 100 символов")
    var position: String,

    @field:Email(message = "Некорректный email")
    @field:NotBlank(message = "Email не может быть пустым")
    @field:Size(max = 100, message = "Email не должен превышать 100 символов")
    var email: String,

    @field:NotNull(message = "Дата приема на работу не может быть пустой")
    var hireDate: LocalDate
){
    // Вторичный конструктор без аргументов
    constructor() : this(
        id = null,
        firstName = "",
        lastName = "",
        position = "",
        email = "",
        hireDate = LocalDate.now()
    )
}