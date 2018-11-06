class WordCount {
    companion object {
        fun phrase(s: String): Map<String,Int>  = s
                            .toLowerCase()
                            .replace("\n", " ")
                            .replace(",", " ")
                            .replace("  ", " ")
                            .replace(" '", " ")
                            .replace("' ", " ")
                            .replace(Regex(pattern = "[^a-z0-9' ]"), "")
                            .split(" ")
                            .groupingBy {it}
                            .eachCount()
    }

}

