package org.example.goal.presentation


import org.example.goal.application.GoalService
import org.example.goal.application.request.CreateGoalRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/goal")
class GoalController(
    private val goalService: GoalService
) {

    @PostMapping
    fun createGoal(@RequestBody @Valid request: CreateGoalRequest) {
        goalService.save(request)
    }
}