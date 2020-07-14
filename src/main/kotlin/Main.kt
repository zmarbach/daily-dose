import domain.EmailMessage
import domain.TextMessage
import domain.User
import messengers.EmailMessenger
import messengers.TextMessenger
import services.StubVerseOfTheDayService

fun main(){

    //TODO - switch this out for real service
    val verseOfTheDayService = StubVerseOfTheDayService()
    val messageBuilder = MessageBuilder()
    var textMessage = TextMessage()
    var emailMessage = EmailMessage()

    //TODO - if 5pm (or whatever time I want to send messages)
    if(true){
        try {
            //TODO - add retry logic for failures
            var verseOfTheDayResponse = verseOfTheDayService.retrieveVerseOfTheDay()

            //TODO - pass in whatever we need to build messages
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