package uz.gita.mytestproject.data.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Offer(
    val attributes: List<Attribute>,
    val brand: String,
    val category: String,
    val id: Int,
    val image: Image,
    val merchant: String,
    val name: String
)