class Expression {

    private var DELEMITER_REGEX: String

    init {
        DELEMITER_REGEX = DEFAULT_DELEMITER_REGEX
    }

    fun getTokens(text: String): List<Int> {
        val inputString: String? = toCustomSplitter(text)

        return inputString?.let {
            if (it?.trim().isNullOrEmpty()) return listOf(0)
            else {
                if (it.split(DELEMITER_REGEX.toRegex())?.any { it.toInt() < 0 }) throw RuntimeException()
                it.split(DELEMITER_REGEX.toRegex()).map { it.toInt() }
            }
        }!!
    }

    private fun toCustomSplitter(text: String): String? {
        val result = Regex(NEWLINE_REGEX).find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            DELEMITER_REGEX = customDelimiter

            it.groupValues[2]
        } ?: text
    }

    companion object {
        private val NEWLINE_REGEX = """//(.)\\n(.*)"""
        private val DEFAULT_DELEMITER_REGEX = ",|:"
    }
}
