package com.example.algorithmsanonymous

import com.google.gson.annotations.SerializedName

data class YelpSearchResult(
        @SerializedName("total") val total: Int,
        @SerializedName("businesses") val places: List<YelpPlaces>
)

data class YelpPlaces(
        val name: String,
        val rating: Double,
        val price: String,
        @SerializedName("review_count") val numReviews: Int,
        @SerializedName("distance") val distanceInMeters: Double, //In meters
        @SerializedName("image_url") val imageUrl: String,
        val categories: List<YelpCategory>,
        val location: YelpLocation
)

{
    fun displayDistance(): String {
        val milesPerMeter = 0.000621371
        val distanceInMiles = "%.2f".format(distanceInMeters * milesPerMeter)
        return "$distanceInMiles miles"
    }
}

data class YelpCategory(
        val title: String
)

data class YelpLocation(
        @SerializedName("address1") val address: String
)