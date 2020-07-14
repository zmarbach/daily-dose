package services

import api.VerseOfTheDayResponse

class StubVerseOfTheDayService : VerseOfTheDayService {
    override fun retrieveVerseOfTheDay(): VerseOfTheDayResponse {
        //TODO - probably change return type after I figure out what the YouVersion API returns (verse text, chapter, picture, etc)
        return VerseOfTheDayResponse()
    }
}