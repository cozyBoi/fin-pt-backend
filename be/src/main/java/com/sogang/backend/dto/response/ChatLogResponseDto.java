package com.sogang.backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Chat의 log 목록 반환용 dto, 이들의 배열로 반환한다.")
public class ChatLogResponseDto {
    @Schema(description = "로그 아이디")
    private Long logId;

    @Schema(description = "응답 개요")
    private String summary;
}
