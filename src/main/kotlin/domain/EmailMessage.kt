package domain

class EmailMessage(var subjectLine: String = "") : Message() {

    //TODO - dynamic subject line... "Here is your Daily Dose! John 3:16" - book, chapter verse all change day to day
}