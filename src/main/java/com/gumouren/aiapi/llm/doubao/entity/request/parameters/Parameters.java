package com.gumouren.aiapi.llm.doubao.entity.request.parameters;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gumouren.aiapi.llm.doubao.entity.request.parameters.tool.Tool;
import com.gumouren.aiapi.llm.doubao.entity.request.parameters.toolChoice.ToolChoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: gyh
 * @Date: 2024-07-03 16:23
 * @Description:
 */
@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Parameters implements Serializable {

    /**
     * 用于指定返回结果的格式，默认为 text，也可设置为 message。
     */
    @JsonProperty("result_format")
    private String resultFormat = "message";

    /**
     * 生成时使用的随机数种子。
     */
    @JsonProperty("seed")
    private Integer seed;

    /**
     * 用于限制模型生成 token 的数量。
     */
    @JsonProperty("max_tokens")
    private Integer maxTokens;

    /**
     * 生成时，核采样方法的概率阈值。
     */
    @JsonProperty("top_p")
    private Float topP = 0.8f;

    /**
     * 生成时，采样候选集的大小。
     */
    @JsonProperty("top_k")
    private Integer topK;

    /**
     * 用于控制模型生成时连续序列中的重复度。
     */
    @JsonProperty("repetition_penalty")
    private Float repetitionPenalty;

    /**
     * 用户控制模型生成时整个序列中的重复度。
     */
    @JsonProperty("presence_penalty")
    private Float presencePenalty;

    /**
     * 用于控制随机性和多样性的程度。
     */
    @JsonProperty("temperature")
    private Float temperature;

    /**
     * 用于实现内容生成过程的精确控制。
     */
    @JsonProperty("stop")
    private List<String> stop;

    /**
     * 控制模型在生成文本时是否参考使用互联网搜索结果。
     */
    @JsonProperty("enable_search")
    private Boolean enableSearch;

    /**
     * 控制在流式输出模式下是否开启增量输出。
     */
    @JsonProperty("incremental_output")
    private Boolean incrementalOutput;

    /**
     * 用于指定可供模型调用的工具列表。
     */
    @JsonProperty("tools")
    private List<Tool> tools;

    /**
     * 用于控制模型调用指定工具。
     */
    @JsonProperty("tool_choice")
    private ToolChoice toolChoice;
}
