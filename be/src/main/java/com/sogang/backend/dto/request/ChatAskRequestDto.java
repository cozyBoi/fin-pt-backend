package com.sogang.backend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Chat의 질문용 dto")
public class ChatAskRequestDto {
    @Schema(description = "질문내용")
    private String ask;
}
