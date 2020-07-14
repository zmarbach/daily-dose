package providers

import api.Image
import api.Verse
import api.VerseOfTheDayResponse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import services.YouVersionVerseOfTheDayService

private const val TEST_HUMAN_REFERENCE = "Galatians 5:1"
private const val TEST_USFMS = "GAL.5.1"
private const val TEST_VERSE_URL = "https://www.bible.com/bible/1/GAL.5.1"
private const val TEST_VERSE_TEXT = "Stand fast therefore in the liberty wherewith Christ hath made us free, and be not entangled again with the yoke of bondage."
private const val TEST_IMAGE_URL = "//imageproxy-cdn.youversionapi.com/{width}x{height},png/https://s3.amazonaws.com/static-youversionapi-com/images/base/20830/1280x1280.jpg"
private const val TEST_ATTRIBUTION = "© YouVersion"


internal class VerseOfTheDayProviderTest {
    private var youVersionVerseOfTheDayService = YouVersionVerseOfTheDayService()

    lateinit var testObj:VerseOfTheDayProvider

    @BeforeEach
    fun setUp() {
        testObj = VerseOfTheDayProvider(youVersionVerseOfTheDayService)
    }

    @Test
    fun retrieveVerseOfTheDayRealTest() {
        //act
        val response = youVersionVerseOfTheDayService.retrieveVerseOfTheDay(195)//Test for specific day (confirmed data using Postman)

        //assert
        assertVerseOfTheDayResponse(response,"195", Verse(TEST_HUMAN_REFERENCE, listOf(TEST_USFMS), TEST_VERSE_URL, TEST_VERSE_TEXT), Image(TEST_IMAGE_URL, TEST_ATTRIBUTION))
    }

    private fun assertVerseOfTheDayResponse(actualResponse: VerseOfTheDayResponse, expectedDay: String, expectedVerse: Verse, expectedImage:Image) {
        assertEquals(expectedDay, actualResponse.day)
        assertEquals(expectedVerse.humanReference, actualResponse.verse.humanReference)
        assertEquals(expectedVerse.text, actualResponse.verse.text)
        assertEquals(expectedVerse.url, actualResponse.verse.url)
        assertEquals(expectedVerse.usfms, actualResponse.verse.usfms)
        assertEquals(expectedImage.url, actualResponse.image.url)
        assertEquals(expectedImage.attribution, actualResponse.image.attribution)
    }
}