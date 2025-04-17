package com.example.app.employeeaccounting.service

import com.example.app.employeeaccounting.controller.ResourceNotFoundException
import com.example.app.employeeaccounting.entity.Employee
import com.example.app.employeeaccounting.repo.EmployeeRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService(private val employeeRepository: EmployeeRepo) {

    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    fun getEmployeeById(id: Long): Employee =
        employeeRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Сотрудник с ID $id не найден")
        }

    fun createEmployee(employee: Employee): Employee = employeeRepository.save(employee)

    fun updateEmployee(id: Long, employeeDetails: Employee): Employee {
        val employee = getEmployeeById(id)
        return employeeRepository.save(
            employee.copy(
                firstName = employeeDetails.firstName,
                lastName = employeeDetails.lastName,
                position = employeeDetails.position,
                email = employeeDetails.email,
                hireDate = employeeDetails.hireDate
            )
        )
    }

    fun deleteEmployee(id: Long) {
        val employee = getEmployeeById(id)
        employeeRepository.delete(employee)
    }

    fun searchEmployeesByPosition(position: String): List<Employee> =
        employeeRepository.searchByPosition(position)
}