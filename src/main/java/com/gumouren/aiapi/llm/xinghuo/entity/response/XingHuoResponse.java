package com.gumouren.aiapi.llm.xinghuo.entity.response;

import com.gumouren.aiapi.llm.doubao.entity.response.usage.Usage;
import com.gumouren.aiapi.llm.qwen.entity.response.output.Choice;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * @author gumouren
 * @description:
 * @date 2024/12/22 20:08
 */
@Data
@Slf4j
public class XingHuoResponse implements Serializable {

    private String sid;
    private String code;
    private String message;
    private long created;
    private Usage usage;
    private List<Choice> choices;
}
