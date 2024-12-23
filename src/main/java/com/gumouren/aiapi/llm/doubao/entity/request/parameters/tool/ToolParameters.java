package com.gumouren.aiapi.llm.doubao.entity.request.parameters.tool;

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
 * @Author: gyh
 * @Date: 2024-07-03 16:25
 * @Description:
 */
@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ToolParameters implements Serializable {

    @JsonProperty("type")
    private String type;

    @JsonProperty("properties")
    private Properties properties;

    @JsonProperty("required")
    private List<String> required;
}
