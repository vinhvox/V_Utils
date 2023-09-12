package pyxis.uzuki.live.richutilskt

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * format date with DateFormat string
 *
 * @param[format] optional. default is yyyy-MM-dd HH:mm:ss (2017-06-02 19:20:00)
 * @return Formatted Date
 */
fun Date.asString(format: String? = "yyyy-MM-dd HH:mm:ss"): String = SimpleDateFormat(format, Locale.getDefault()).format(this)

/**
 * get readable string of given timestamp.
 *
 * @param[format] optional. default is yyyy-MM-dd HH:mm:ss (2017-06-02 19:20:00)
 * @return Formatted Date
 */
fun Long.asDateString(format: String? = "yyyy-MM-dd HH:mm:ss"): String = Date(this).asString(format)

/**
 * parsing date from String
 *
 * @param[format] optional. default is yyyy-MM-dd HH:mm:ss (2017-06-02 19:20:00)
 * @return Date object, Nullable
 */
fun String.parseDate(format: String? = "yyyy-MM-dd HH:mm:ss"): Date? = try {
    SimpleDateFormat(format, Locale.getDefault()).parse(this)
} catch (e: Exception) {
    null
}

/**
 * format formatted date to another formatted date
 *
 * @param[fromFormat] original date format
 * @param[toFormat] to convert
 * @return new Formatted Date
 */
fun String.toDateString(fromFormat: String, toFormat: String): String {
    val result: String;
    val df: SimpleDateFormat = SimpleDateFormat(fromFormat, Locale.getDefault())
    val df2: SimpleDateFormat = SimpleDateFormat(toFormat, Locale.getDefault())
    try {
        result = df2.format(df.parse(this))
    } catch (e: ParseException) {
        return this
    }
    return result
}