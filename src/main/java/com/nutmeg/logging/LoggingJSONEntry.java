package com.nutmeg.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by adelaida on 24/04/2017.
 */
public class LoggingJSONEntry {

    private String service;
    private String message;
    private String dateTime;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static class Builder{
        private String service;
        private String message;

        public static Builder aLogginJSONEntry(){
            return new Builder();
        }

        public Builder service(String service){
            this.service = service;
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public LoggingJSONEntry build(){
            LoggingJSONEntry loggingJSONEntry =  new LoggingJSONEntry();
            loggingJSONEntry.setService(service);
            loggingJSONEntry.setMessage(message);
            String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            loggingJSONEntry.setDateTime(formattedDateTime);
            return loggingJSONEntry;
        }

    }
}
