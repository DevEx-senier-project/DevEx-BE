package com.DevEx.DevExBE.domain.bookmark;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmark")
@RequiredArgsConstructor
@Tag(name = "[8] BookMark", description = "BookMark API")
public class BookMarkController {

    private final BookMarkService bookMarkService;

    @Operation(summary = "북마크 생성", description = "북마크 생성")
    @PostMapping
    public ResponseEntity<Long> createBookMark(@AuthenticationPrincipal UserDetails user, @RequestBody UserQuoteRequestDto userQuoteRequestDto){
        System.out.println(userQuoteRequestDto);
        Long bookMarkId = bookMarkService.createBookMark(user, userQuoteRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookMarkId);
    }

    @Operation(summary = "북마크 삭제", description = "북마크 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> createBookMark(@PathVariable Long id){
        bookMarkService.deleteBookMark(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
