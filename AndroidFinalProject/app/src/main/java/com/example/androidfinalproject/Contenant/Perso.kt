import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Perso(
    val name: String,
    val img: String
) : Parcelable