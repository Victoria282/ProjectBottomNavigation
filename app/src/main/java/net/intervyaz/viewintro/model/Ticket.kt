package net.intervyaz.viewintro.model

data class Ticket(
    var id: Int,
    var flightNumber: String,
    var startTime: String,
    var endTime: String,
    var date: String,
    var startPlace: String,
    var endPlace: String,
    var flightTime: String
)
