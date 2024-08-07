package ru.aurorahost.location

import org.osmdroid.util.GeoPoint

data class LocationModel(
    val speed: Float = 0.0f,
    val distance: Float = 0.0f,
    val geoPointsList: AbstractList<GeoPoint>,
)
