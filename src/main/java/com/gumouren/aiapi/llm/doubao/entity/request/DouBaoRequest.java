package com.gumouren.aiapi.llm.doubao.entity.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gumouren.aiapi.llm.doubao.constant.DouBaoModel;
import com.gumouren.aiapi.llm.doubao.entity.request.parameters.Parameters;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: gyh
 * @Date: 2024-07-02 16:37
 * @Description:
 */
@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class DouBaoRequest implements Serializable {


    @JsonProperty("model")
    private String model = DouBaoModel.DOUBAO_LITE_4K.getModel();

    /**
     * 用于控制模型生成的参数。
     */
    @JsonProperty("parameters")
    private Parameters parameters = new Parameters();

    /**
     * 用户与模型的对话历史，格式为 {"role": 角色, "content": 内容}。
     */
    @JsonProperty("messages")
    private List<ChatMessage> messages;

    private Boolean stream;
}
