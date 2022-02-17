rootProject.name = "temp"
include("app")
include("common")
include(
    "user-api",
    "user-api:user-domain",
    "user-api:user-application",
    "user-api:user-presentation",
    "user-api:user-infrastructure"
)
include(
    "goal-api",
    "goal-api:goal-domain",
    "goal-api:goal-application",
    "goal-api:goal-presentation",
    "goal-api:goal-infrastructure"
)