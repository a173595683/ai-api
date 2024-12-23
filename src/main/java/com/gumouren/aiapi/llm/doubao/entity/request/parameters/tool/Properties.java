package com.gumouren.aiapi.llm.doubao.entity.request.parameters.tool;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Author: gyh
 * @Date: 2024-07-03 16:26
 * @Description:
 */
@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Properties implements Serializable {

    @JsonProperty("location")
    private Property location;

    @JsonProperty("unit")
    private Property unit;
}
