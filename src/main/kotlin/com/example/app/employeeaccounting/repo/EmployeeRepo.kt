package com.example.app.employeeaccounting.repo

import com.example.app.employeeaccounting.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepo : JpaRepository<Employee, Long> {
    fun findByPosition(position: String): List<Employee>

    @Query("SELECT e FROM Employee e WHERE LOWER(e.position) LIKE %:position%")
    fun searchByPosition(@Param("position") position: String): List<Employee>
}