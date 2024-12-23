package com.gumouren.aiapi.llm.qwen.constant;

import lombok.Getter;

/**
 * @author gumouren
 * @description: TODO
 * @date 2024/12/22 21:21
 */
@Getter
public enum QwenModel {
    QWEN_TURBO("千问Turbo", "qwen-turbo"),
    QWEN_PLUS("千问Plus", "qwen-plus"),
    QWEN_7B_CHAT("千问7B聊天", "qwen-7b-chat"),
    QWEN_14B_CHAT("千问14B聊天", "qwen-14b-chat"),
    QWEN_72B_CHAT("千问72B聊天", "qwen-72b-chat");

    private final String description;
    private final String model;

    QwenModel(String description, String model) {
        this.description = description;
        this.model = model;
    }

}
