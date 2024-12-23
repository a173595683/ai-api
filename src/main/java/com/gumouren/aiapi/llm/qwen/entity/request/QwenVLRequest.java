package com.gumouren.aiapi.llm.qwen.entity.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.gumouren.aiapi.llm.qwen.constant.QwenModel;
import com.gumouren.aiapi.llm.qwen.entity.request.input.InputVL;
import com.gumouren.aiapi.llm.qwen.entity.request.parameters.Parameters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gumouren
 * @description: 千文多模态模型
 * @date 2024/12/22 20:08
 */
@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class QwenVLRequest {

    /**
     * 指定用于对话的通义千问模型名。
     * 目前可选择 qwen-turbo、qwen-plus、qwen-max 等。
     */
    @JsonProperty("model")
    private String model = QwenModel.QWEN_PLUS.getModel();

    /**
     * 输入模型的信息。
     */
    @JsonProperty("input")
    private InputVL input = new InputVL();

    /**
     * 用于控制模型生成的参数。
     */
    @JsonProperty("parameters")
    private Parameters parameters = new Parameters();




}
