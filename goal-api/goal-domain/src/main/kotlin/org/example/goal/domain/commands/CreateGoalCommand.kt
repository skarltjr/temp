package org.example.goal.domain.commands

import org.example.goal.domain.Goal

class CreateGoalCommand(
    val title:String,
    val userName:String,
    val goalType:Goal.GoalType
)