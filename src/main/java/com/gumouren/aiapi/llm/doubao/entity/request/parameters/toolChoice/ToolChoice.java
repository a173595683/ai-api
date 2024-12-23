package com.gumouren.aiapi.llm.doubao.entity.request.parameters.toolChoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gyh
 * @Date: 2024-07-03 16:29
 * @Description:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToolChoice implements Serializable {

    @JsonProperty("type")
    private String type;

    @JsonProperty("function")
    private Function function;
}
