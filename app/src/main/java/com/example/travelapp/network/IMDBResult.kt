package com.example.travelapp.network

import com.google.gson.annotations.SerializedName


data class IMDBResult (
    @SerializedName("id"           ) var id           : Int?    = null,
    @SerializedName("abbreviation" ) var abbreviation : String? = null,
    @SerializedName("city"         ) var city         : String? = null,
    @SerializedName("conference"   ) var conference   : String? = null,
    @SerializedName("division"     ) var division     : String? = null,
    @SerializedName("full_name"    ) var fullName     : String? = null,
    @SerializedName("name"         ) var name         : String? = null
)