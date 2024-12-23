package com.gumouren.aiapi.llm.qwen.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author gumouren
 * @description:
 * @date 2024/12/22 20:08
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC) // 确保构造方法是公共的
public class QwenMessage implements Serializable {


    // 角色，可选值：system、user、assistant
    @JsonProperty("role")
    private String role;


    private String name;

    // 模型输出的内容
    @JsonProperty("content")
    private String content;

    // 工具调用参数
    @JsonProperty("tool_calls")
    private List<ToolCall> toolCalls;

    public QwenMessage() {

    }

    public static class ToolCall {
        // 工具类型，当前只可能为function
        @JsonProperty("type")
        private String type;

        // 工具信息
        @JsonProperty("function")
        private Function function;

        public static class Function {

            // 工具或函数的名称
            @JsonProperty("name")
            private String name;

            // 工具入参
            @JsonProperty("arguments")
            private String arguments;
        }
    }
}
