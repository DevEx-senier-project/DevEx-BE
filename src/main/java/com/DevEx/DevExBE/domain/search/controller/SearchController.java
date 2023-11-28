package com.DevEx.DevExBE.domain.search.controller;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.domain.search.dto.SearchQuoteResponseDto;
import com.DevEx.DevExBE.domain.search.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/search")
@Tag(name = "[3] Search", description = "Search API")
public class SearchController {

    private final SearchService searchService;

    @Operation(summary = "통합 검색", description = "통합 검색")
    @PostMapping
    public ResponseEntity<List<SearchQuoteResponseDto>> search(@RequestBody UserQuoteRequestDto userQuoteRequestDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(searchService.search(userQuoteRequestDto));
    }

}
