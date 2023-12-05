package com.DevEx.DevExBE.domain.bookmark;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.domain.users.UserService;
import com.DevEx.DevExBE.domain.users.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookMarkService {

    private final BookMarkRepository bookMarkRepository;
    private final UserService userService;

    public Long createBookMark(UserDetails user, UserQuoteRequestDto userQuoteRequestDto) {
        Users userEntity = userService.getUserEntityByEmail(user.getUsername());
        BookMark bookMarkEntity = BookMark.toEntity(userEntity, userQuoteRequestDto);
        BookMark savedBookMark = bookMarkRepository.save(bookMarkEntity);
        return savedBookMark.getId();
    }

    public void deleteBookMark(Long id) {
        bookMarkRepository.deleteById(id);
    }
}
