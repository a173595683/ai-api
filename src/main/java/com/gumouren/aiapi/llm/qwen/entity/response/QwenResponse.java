package com.gumouren.aiapi.llm.qwen.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gumouren.aiapi.llm.qwen.entity.response.output.Output;
import com.gumouren.aiapi.llm.qwen.entity.response.usage.Usage;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gumouren
 * @description:
 * @date 2024/12/22 20:08
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QwenResponse implements Serializable {

    // Output类，包含生成的内容或选择项
    private Output output;
    private Usage usage;
    @JsonProperty("request_id")
    private String requestId;

}
