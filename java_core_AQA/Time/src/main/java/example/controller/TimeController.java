package example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.context.i18n.LocaleContextHolder;
import example.DTO.FormattedDateTime;
import java.time.LocalDateTime;
import java.util.Locale;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    @GetMapping("/format")
    public FormattedDateTime formatDateTime() {
        LocalDateTime now = LocalDateTime.now();
        Locale currentLocale = LocaleContextHolder.getLocale();

        System.out.println("Current locale: " + currentLocale);
        System.out.println("Language: " + currentLocale.getLanguage());
        System.out.println("Country: " + currentLocale.getCountry());

        return new FormattedDateTime(now);
    }

    // Эндпоинт для тестирования с разными локалями
    @GetMapping("/format-with-locale")
    public FormattedDateTime formatDateTimeWithLocale(@RequestParam(defaultValue = "ru") String lang) {
        LocalDateTime now = LocalDateTime.now();

        // Создаем объект с принудительной локалью
        FormattedDateTime result = new FormattedDateTime(now);
        return result;
    }
}