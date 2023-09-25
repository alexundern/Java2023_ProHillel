package com.servlet.hw_34.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер для проверки доступности сервиса.
 */
@RestController
@RequestMapping("")
@RequiredArgsConstructor
@Slf4j
public class PingController {
    private static final String CALL_ENDPOINT = "call endpoint : %s ";

    /**
     * Проверить доступность сервиса.
     *
     * @return Строка "OK".
     */
    @GetMapping("/ping")
    public String ping() {
        log.info(String.format(CALL_ENDPOINT, "ping"));
        return "OK";
    }
}
