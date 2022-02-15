package org.example.goal

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GoalController {
    @GetMapping("/goal")
    fun exampleGaol(): String {
        return "goal"
    }
}