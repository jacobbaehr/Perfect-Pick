package com.example.algorithmsanonymous

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class YelpSearchResult(
        @SerializedName("total") val total: Int,
        @SerializedName("businesses") val places: List<YelpPlaces>
)

@Parcelize
data class YelpPlaces(
    val name: String,
    val rating: Double,
    val price: String,
    val id: String,
    @SerializedName("review_count") val numReviews: Int,
    @SerializedName("distance") val distanceInMeters: Double, //In meters
    @SerializedName("image_url") val imageUrl: String,
    val categories: @RawValue List<YelpCategory>,
    val location: @RawValue YelpLocation
): Parcelable

{
    fun displayDistance(): String {
        val milesPerMeter = 0.000621371
        val distanceInMiles = "%.2f".format(distanceInMeters * milesPerMeter)
        return "$distanceInMiles Miles"
    }
}

data class YelpCategory(
        val title: String
)

data class YelpLocation(
        @SerializedName("address1") val address: String
)