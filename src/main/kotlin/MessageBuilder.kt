import domain.EmailMessage
import domain.TextMessage
import api.VerseOfTheDayResponse

class MessageBuilder {
    //TODO - might need subclasses for TextMessageBuilder and EmailMessageBuilder if enough differences between the 2
    fun buildTextMessage(verseOfTheDayResponse: VerseOfTheDayResponse) : TextMessage {
        //do stuff here to build text message based on YouVersion API response
        return TextMessage()
    }

    fun buildEmailMessage(verseOfTheDayResponse: VerseOfTheDayResponse): EmailMessage {
        //do stuff here to build email message based on YouVersion API response
        return EmailMessage()
    }
}
