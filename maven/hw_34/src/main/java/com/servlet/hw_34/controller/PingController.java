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
    private static final String PING_ENDPOINT = "ping";
    /**
     * Проверить доступность сервиса.
     *
     * @return Строка "OK".
     */
    @GetMapping("/ping")
    public String ping() {
        log.info(String.format(CALL_ENDPOINT, PING_ENDPOINT));
        return "OK";
    }
}
