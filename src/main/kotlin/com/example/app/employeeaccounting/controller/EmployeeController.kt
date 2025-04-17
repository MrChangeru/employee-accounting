package com.example.app.employeeaccounting.controller

import com.example.app.employeeaccounting.entity.Employee
import com.example.app.employeeaccounting.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getAllEmployees(): List<Employee> = employeeService.getAllEmployees()

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): ResponseEntity<Employee> =
        ResponseEntity.ok(employeeService.getEmployeeById(id))

    @PostMapping
    fun createEmployee(@RequestBody employee: Employee): Employee =
        employeeService.createEmployee(employee)

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id: Long, @RequestBody employeeDetails: Employee): ResponseEntity<Employee> =
        ResponseEntity.ok(employeeService.updateEmployee(id, employeeDetails))

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Void> {
        employeeService.deleteEmployee(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/search")
    fun searchEmployeesByPosition(@RequestParam position: String): List<Employee> =
        employeeService.searchEmployeesByPosition(position)
}