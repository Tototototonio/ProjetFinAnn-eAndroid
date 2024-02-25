import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Parcelize
data class Episode(
    val img: String,
    val name: String,
    val number: Int,
) : Parcelable
