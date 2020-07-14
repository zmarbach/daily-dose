package services

class YouVersionVerseOfTheDayService : VerseOfTheDayService {

    override fun retrieveVerseOfTheDay(): String {
        //TODO - connect with YouVersion API and get verse of the day
        //TODO - probably change return type after I figure out what the YouVersion API returns (verse text, chapter, picture, etc)
        return "foo"
    }
}