package services

import api.VerseOfTheDayResponse

interface VerseOfTheDayService {

    //TODO - probably change return type after I figure out what the YouVersion API returns (verse text, chapter, picture, etc)
    fun retrieveVerseOfTheDay(currentDay:Int): VerseOfTheDayResponse
}