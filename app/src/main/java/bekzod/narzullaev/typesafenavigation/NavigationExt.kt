package bekzod.narzullaev.typesafenavigation

import android.os.Build
import android.util.Log
import androidx.navigation.NavController

fun String?.getClassByName(): Any? {
    try {
        this?.let {
            return Class.forName("bekzod.narzullaev.typesafenavigation.$it")
        }
        return null
    } catch (e: Exception) {
        Log.d("TAG", "getClass: ${e.message}")
        return null
    }
}

fun NavController.navigateSingleTop(
    pageId: String?,
    singleTop: Boolean = true
) {
    try {
        pageId.getClassByName()?.let {
            this.navigate(it) {
                launchSingleTop = singleTop
            }
        }
    } catch (e: Exception) {
        Log.d("TAG", "navigateSingleTop: ${e.message}")
    }
}

fun NavController.navigateSingleTop(
    screen: Any,
    singleTop: Boolean = true
) {
    try {
        this.navigate(screen) {
            launchSingleTop = singleTop
        }
    } catch (e: Exception) {
        Log.d("TAG", "navigateSingleTop: ${e.message}")
    }
}