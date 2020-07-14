package messengers

import domain.TextMessage

class TextMessenger : BaseMessenger() {

    //do stuff specific to sending a text message

    fun sendText(textMessage: TextMessage, phoneNumber: String) {
        //sendText (need to find free SMS API ideally)
    }
}