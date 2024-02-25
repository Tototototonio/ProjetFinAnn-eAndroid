import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Test(
    val story: String,
    val episodes: List<Episode>,
    val persos: List<Perso>,
    val année: Int,
    val producteur: String,
    val titre: String,
    val img: String
) : Parcelable