package moe.styx.types

import kotlinx.serialization.Serializable

enum class TMDBOrder(val type: Int, val title: String) {
    ORIGINAL_AIR_DATE(1, "Original air date"),
    ABSOLUTE(2, "Absolute"),
    DVD(3, "DVD"),
    DIGITAL(4, "Digital"),
    STORY_ARC(5, "Story Arc"),
    PRODUCTION(6, "Production"),
    TV(7, "TV")
}

interface IMapping {
    val matchFrom: Double
    val matchUntil: Double
    val remoteID: Int
    val offset: Double?
}


@Serializable
data class BasicMapping(
    override var matchFrom: Double = -1.0,
    override var matchUntil: Double = -1.0,
    override var remoteID: Int = 0,
    override var offset: Double? = null
) : IMapping

@Serializable
data class TMDBMapping(
    override var matchFrom: Double = -1.0,
    override var matchUntil: Double = -1.0,
    override var remoteID: Int = 0,
    var seasonEntry: Int = 1,
    var orderType: TMDBOrder? = null,
    var orderID: String? = null,
    override var offset: Double? = null
) : IMapping


@Serializable
data class MappingCollection(
    val tmdbMappings: MutableList<TMDBMapping> = mutableListOf(),
    val anilistMappings: MutableList<BasicMapping> = mutableListOf(),
    val malMappings: MutableList<BasicMapping> = mutableListOf()
)