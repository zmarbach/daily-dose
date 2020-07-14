package providers

import api.VerseOfTheDayResponse
import services.VerseOfTheDayService

class VerseOfTheDayProvider(var verseOfTheDayService: VerseOfTheDayService) {

    fun retrieveVerseOfTheDay(currentDay:Int): VerseOfTheDayResponse{
        //TODO - add retry logic for failures?
        //will have to see what error messages they give us back
        return try{
            verseOfTheDayService.retrieveVerseOfTheDay(currentDay)
        } catch (e:Exception){
            println("Exception while trying to retrieve Verse of the Day from YouVersion API ----> " + e.message)
            VerseOfTheDayResponse()
        }
    }

}