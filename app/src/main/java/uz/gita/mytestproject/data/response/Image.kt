package uz.gita.mytestproject.data.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Image(
    val height: Int,
    val url: String,
    val width: Int
)