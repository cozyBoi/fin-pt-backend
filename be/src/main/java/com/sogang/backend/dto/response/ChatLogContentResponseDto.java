package com.sogang.backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Chat의 log 내용 반환용 dto, 이들의 배열로 반환한다.")
public class ChatLogContentResponseDto {
    @Schema(description = "질문 내용")
    private String ask;

    @Schema(description = "답변 내용")
    private String response;
}
