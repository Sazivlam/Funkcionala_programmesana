class Isogram {
    companion object {
        fun isIsogram(s: String):Boolean = s
                     .toLowerCase()
                     .replace("-","")
                     .replace(" ","")
                     .toSet()   //Set of unique elements(excluding "-" and " " and lowercased)
                     .size
                     .compareTo(s.toLowerCase()
                             .replace("-","")
                             .replace(" ","")//Input string (excluding "-" and " " and lowercased)
                             .length)   //returns 0 if Strings are same
                     .toString()
                     .replace("0","true")
                     .toBoolean()
        }
    }
