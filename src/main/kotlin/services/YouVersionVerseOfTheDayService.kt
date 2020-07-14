package services

import api.VerseOfTheDayResponse
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate

class YouVersionVerseOfTheDayService() : VerseOfTheDayService {

    override fun retrieveVerseOfTheDay(currentDay:Int): VerseOfTheDayResponse {
        //TODO - extract from application yml
        val youVersionBaseUrl = "https://developers.youversionapi.com/1.0/verse_of_the_day/"
        //TODO - get real token and extract from application.yaml
        val apiToken = "6grJ6jqcI2ILCK8OgwLXAM3QOcA"
        var fullUrl = "$youVersionBaseUrl$currentDay?version_id=1"
        var headers = HttpHeaders()
        headers.add("x-youversion-developer-token", apiToken)
        headers.add("accept", "application/json")
        headers.add("user-agent", "DailyDose")
        var httpEntity = HttpEntity(null, headers)
        var restTemplate = RestTemplate()
        var verseOfTheDayResponse = restTemplate.exchange(fullUrl, HttpMethod.GET, httpEntity, VerseOfTheDayResponse::class.java).body
        return verseOfTheDayResponse
    }
}