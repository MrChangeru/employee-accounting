package com.example.app.employeeaccounting.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/") // Обработка GET-запроса на корневой URL
    fun showHomePage(): String {
        return "index" // Возвращает имя представления (HTML-файла)
    }
}