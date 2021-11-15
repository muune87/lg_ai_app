package io.muracle.lgaiapp.utils

import android.content.res.Resources
import android.util.TypedValue

class Constants {

    companion object{
        const val TAG = "LG_AI_APP"
        fun pxTodp(dp:Float, resources:Resources): Int{
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.displayMetrics
            ).toInt()
        }
    }


}

enum class PAGE {
    CHOOSE1, CHOOSE2, CHOOSE3, CHOOSE4
}
