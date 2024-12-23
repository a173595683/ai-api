package com.gumouren.aiapi.llm.doubao.constant;

import lombok.Getter;

/**
 * @author gumouren
 * @description: TODO
 * @date 2024/12/22 21:21
 */
@Getter
public enum DouBaoModel {
    DOUBAO_EMBEDDING("豆包嵌入式大型模型", "Doubao-embedding-large"),
    DOUBAO_PRO_4K("豆包专业版4K", "ep-20241030162942-f4tdf"),
    DOUBAO_PRO_32K("豆包专业版32K", "ep-20241101161129-lnxwf"),
    DOUBAO_LITE_4K("豆包精简版4K", "ep-20241030105138-54288"),
    DOUBAO_LITE_32K("豆包精简版32K", "ep-20241101125344-cxpll");

    private final String description;
    private final String model;

    DouBaoModel(String description, String model) {
        this.description = description;
        this.model = model;
    }

}
