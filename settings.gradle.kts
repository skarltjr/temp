rootProject.name = "temp"
include("app")
include("common")
include(
    "user-api",
    "user-api:user-domain",
    "user-api:user-presentation"
)
include(
    "goal-api",
    "goal-api:goal-domain",
    "goal-api:goal-presentation"
)
