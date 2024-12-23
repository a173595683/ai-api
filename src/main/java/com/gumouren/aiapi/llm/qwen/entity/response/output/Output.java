package com.gumouren.aiapi.llm.qwen.entity.response.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Output implements Serializable {

    /**
     * 模型输出的内容。当result_format设置为text时返回该字段。
     */
    private String text;

    // 生成停止的原因，有三种情况：null、stop、length
    @JsonProperty("finish_reason")
    private String finishReason;

    // 当result_format设置为message时返回该字段
    private List<Choice> choices;
    @JsonProperty("token_ids")
    private List<Integer> tokenIds;

    private List<String> tokens;



}
