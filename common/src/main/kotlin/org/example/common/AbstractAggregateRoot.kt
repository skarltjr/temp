package org.example.common

import java.util.*

abstract class AbstractAggregateRoot{
    private val events: MutableList<DomainEvent> = mutableListOf()

    protected fun registerEvent(event: DomainEvent) {
        this.events.add(event)
    }

    fun pollAllEvent(): List<DomainEvent> {
        return if (events.isEmpty())
            Collections.emptyList()
        else {
            val copyEvents = mutableListOf<DomainEvent>()
            copyEvents.addAll(events)
            events.clear()

            copyEvents
        }
    }
}