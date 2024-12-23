package com.gumouren.aiapi.llm.doubao.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gumouren.aiapi.llm.doubao.entity.response.usage.Usage;
import com.gumouren.aiapi.llm.qwen.entity.response.output.Choice;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: gyh
 * @Date: 2024-07-03 15:49
 * @Description:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DouBaoResponse implements Serializable {

    private String id;
    private String model;
    private String object;
    private long created;
    private Usage usage;
    private List<Choice> choices;
}
