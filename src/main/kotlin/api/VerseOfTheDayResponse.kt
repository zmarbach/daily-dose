package api

import com.fasterxml.jackson.annotation.JsonProperty

//TODO - Maybe a BUILDER?
data class VerseOfTheDayResponse(@JsonProperty("verse") var verse:Verse = Verse(),
                                 @JsonProperty("day") var day:String = "",
                                 @JsonProperty("image") var image:Image = Image()) {
}

data class Verse(@JsonProperty("human_reference") var humanReference:String = "",
                 @JsonProperty("usfms") var usfms:List<String> = emptyList(),
                 @JsonProperty("url") var url:String = "",
                 @JsonProperty("text") var text:String = "") {
}

data class Image(@JsonProperty("url") var url:String = "",
                 @JsonProperty("attribution") var attribution:String ="") {
}


