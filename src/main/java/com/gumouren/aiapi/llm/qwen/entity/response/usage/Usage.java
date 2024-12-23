package com.gumouren.aiapi.llm.qwen.entity.response.usage;

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
public class Usage implements Serializable {
    // 模型输出内容的token个数
    @JsonProperty("output_tokens")
    private int outputTokens;

    // 本次请求输入内容的token个数
    @JsonProperty("input_tokens")
    private int inputTokens;

    // usage.output_tokens与usage.input_tokens的总和
    @JsonProperty("total_tokens")
    private int totalTokens;


}
