import domain.EmailMessage
import domain.TextMessage
import domain.User
import messengers.EmailMessenger
import messengers.TextMessenger
import providers.VerseOfTheDayProvider
import services.StubVerseOfTheDayService
import sun.util.calendar.BaseCalendar
import java.time.LocalDateTime
import java.util.*

fun main(){

    //TODO - switch this out for real service
    val verseOfTheDayService = StubVerseOfTheDayService()
    val verseOfTheDayProvider = VerseOfTheDayProvider(verseOfTheDayService)
    val messageBuilder = MessageBuilder()
    var textMessage = TextMessage()
    var emailMessage = EmailMessage()

    //TODO - maybe change time?
    if(LocalDateTime.now().hour == 10 && LocalDateTime.now().minute == 0 && LocalDateTime.now().second == 0){
        try {
            var verseOfTheDayResponse = verseOfTheDayProvider.retrieveVerseOfTheDay(LocalDateTime.now().dayOfYear)

            textMessage = messageBuilder.buildTextMessage(verseOfTheDayResponse)
            emailMessage = messageBuilder.buildEmailMessage(verseOfTheDayResponse)

        }catch(e: Exception){
            //TODO - load default message from property file
            //TODO - log failures?
            //create default message to send ("Sorry there was an error...please go to this URL for the verse of the day.")
            //set it equal to verse
        }
        //TODO - initialize users and add them to list somewhere else? Property file? On start-up? "bootstrap it"?
        var users:List<User> = arrayListOf(
            User(
                "zacharymarbach@gmail.com",
                "8305156498"
            )
        )
        for(user: User in users){
            if(user.phoneNumber.isNotEmpty()){
                TextMessenger().sendText(textMessage, user.phoneNumber)
            }

            if(user.email.isNotEmpty()){
                EmailMessenger().sendEmail(emailMessage, user.email)
            }
        }

    }
}
