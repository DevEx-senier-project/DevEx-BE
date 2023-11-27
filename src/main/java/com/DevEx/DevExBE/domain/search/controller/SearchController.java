package com.DevEx.DevExBE.domain.search.controller;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.domain.search.dto.SearchQuoteResponseDto;
import com.DevEx.DevExBE.domain.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    public ResponseEntity<List<SearchQuoteResponseDto>> search(@RequestBody UserQuoteRequestDto userQuoteRequestDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(searchService.search(userQuoteRequestDto));
    }

}
