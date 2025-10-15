package example.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class FormattedDateTime {

    @JsonFormat(pattern = "yyyy:MM:dd'##'HH:mm:ss:SSS", locale = "ru")
    private LocalDateTime dateTime;

    @JsonProperty("formatted")
    private String formattedString;

    public FormattedDateTime() {}

    public FormattedDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;

        // Ручное форматирование для дополнительного поля
        java.time.format.DateTimeFormatter formatter =
                java.time.format.DateTimeFormatter.ofPattern("yyyy:MM:dd'##'HH:mm:ss:SSS");
        this.formattedString = dateTime.format(formatter);
    }

    // Геттеры и сеттеры
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getFormattedString() { return formattedString; }
    public void setFormattedString(String formattedString) { this.formattedString = formattedString; }
}