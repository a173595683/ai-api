package com.gumouren.aiapi.llm.xinghuo.constant;

import lombok.Getter;

/**
 * @author gumouren
 * @description:
 * @date 2024/12/22 20:08
 */
@Getter
public enum XingHuoModel {
    LITE("星火精简版", "Lite"),
    PRO("星火专业版", "Pro"),
    PRO_128K("星火专业版128K", "Pro-128K"),
    MAX("星火最大版", "Max"),
    MAX_32K("星火最大版32K", "Max-32K"),
    ULTRA_4_0("星火超极版4.0", "4.0 Ultra");

    private final String description;
    private final String model;

    XingHuoModel(String description, String model) {
        this.description = description;
        this.model = model;
    }

}
