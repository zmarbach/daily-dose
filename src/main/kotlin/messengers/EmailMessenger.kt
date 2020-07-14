package messengers

import domain.EmailMessage

class EmailMessenger : BaseMessenger() {

    //do stuff specific to sending a text message

    fun sendEmail(emailMessage: EmailMessage, email: String){
        //send email
    }
}