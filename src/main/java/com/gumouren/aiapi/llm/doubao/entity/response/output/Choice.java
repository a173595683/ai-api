package com.gumouren.aiapi.llm.doubao.entity.response.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.gumouren.aiapi.llm.doubao.entity.DouBaoMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: gyh
 * @Date: 2024-07-04 16:58
 * @Description:
 */
@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public  class Choice {
    // Message类，表示每个消息
    @JsonProperty("message")
    private DouBaoMessage message;


    // 停止原因，null：生成过程中，stop：stop token导致结束，length：生成长度导致结束
    @JsonProperty("finish_reason")
    private String finishReason;

    private Object logprobs;
    private int index;
    private Delta delta;
}
