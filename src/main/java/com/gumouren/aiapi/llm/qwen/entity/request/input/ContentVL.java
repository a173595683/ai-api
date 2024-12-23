package com.gumouren.aiapi.llm.qwen.entity.request.input;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author gumouren
 * @description:
 * @date 2024/12/22 20:08
 */
@Slf4j
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ContentVL implements Serializable {
    /**
     * 两个字段二选一
     */
    private String image;

    private String text;
}
