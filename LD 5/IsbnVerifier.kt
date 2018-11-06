class IsbnVerifier {

    fun isValid(text: String): Boolean = text
                                    .toLowerCase()
                                    .replace("-","")
                                    .matches(Regex(pattern = "^\\d{9}[\\d|x]$"))
                                    .compareTo(true)
                                    .toString()
                                    .replace("0",text
                                                              .toLowerCase()
                                                              .replace("-",""))
                                    .dropLast(1).foldIndexed(text
                                                                   .toLowerCase()
                                                                   .replace("-","")
                                                                   .matches(Regex(pattern = "^\\d{10}$"))
                                                                   .compareTo(true)
                                                                   .toString()
                                                                   .replace("0",(text
                                                                                               .toLowerCase()
                                                                                               .replace("-","")
                                                                                               .lastOrNull())
                                                                                               .toString())
                                                                   .replace("-1","10")
                                                                   .toInt())
                                    { i, acc, c -> acc + (c-'0')*(10-i) }.rem(11) == 0

}