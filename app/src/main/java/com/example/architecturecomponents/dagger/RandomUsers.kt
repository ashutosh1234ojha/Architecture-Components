package com.example.architecturecomponents.dagger

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



 class RandomUsers() {

     @SerializedName("results")
     @Expose
     private var results: List<Result>? = null
//     @SerializedName("info")
//     @Expose
//     private var info: Info? = null

     fun getResults(): List<Result>? {
         return results
     }

     fun setResults(results: List<Result>) {
         this.results = results
     }

//     fun getInfo(): Info? {
//         return info
//     }
//
//     fun setInfo(info: Info) {
//         this.info = info
//     }
//
//     override fun toString(): String {
//         return ToStringBuilder(this).append("results", results).append("info", info).toString()
//     }
}