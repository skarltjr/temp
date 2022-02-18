package vo

import javax.persistence.Embeddable

@Embeddable
class User(
    val name:String
)