package uz.gita.mytestproject.data.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ProductData(
    val offers: List<Offer>
)