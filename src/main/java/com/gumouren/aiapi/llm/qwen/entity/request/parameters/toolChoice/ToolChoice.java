package com.gumouren.aiapi.llm.qwen.entity.request.parameters.toolChoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gumouren
 * @description:
 * @date 2024/12/22 20:08
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToolChoice implements Serializable {

    @JsonProperty("type")
    private String type;

    @JsonProperty("function")
    private Function function;
}
