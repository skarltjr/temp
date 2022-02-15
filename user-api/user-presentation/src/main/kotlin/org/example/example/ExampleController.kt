package org.example.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController(
    private val exampleService: ExampleService
) {
    @GetMapping("/")
    fun exampleController(): String {
        return exampleService.exampleService()
    }
}