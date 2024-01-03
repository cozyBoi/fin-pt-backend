package com.sogang.backend.controller;

import com.sogang.backend.dto.request.ChatAskRequestDto;
import com.sogang.backend.dto.response.ChatAskResponseDto;
import com.sogang.backend.dto.response.ChatLogContentResponseDto;
import com.sogang.backend.dto.response.ChatLogResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {
    @PostMapping("/ask")
    public ChatAskResponseDto ask(@RequestHeader Long memberId, @RequestBody ChatAskRequestDto chatAskRequestDto){
        return null;
    }

    @GetMapping("/logs")
    public List<ChatLogResponseDto> getLogs(@RequestHeader Long memberId){
        return null;
    }

    @GetMapping("/log")
    public List<ChatLogContentResponseDto> getLog(@RequestHeader Long memberId, @RequestHeader Long logId){
        return null;
    }
}
