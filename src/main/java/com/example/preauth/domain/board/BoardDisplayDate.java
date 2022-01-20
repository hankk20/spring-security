package com.example.preauth.domain.board;

import com.example.preauth.domain.commons.ApplicationConstants;
import com.example.preauth.domain.commons.DisplayDate;

import java.time.LocalDateTime;

public class BoardDisplayDate extends DisplayDate {

    public BoardDisplayDate(LocalDateTime localDateTime) {
        super(ApplicationConstants.BOARD_DISPLAY_DATE_FORMAT, localDateTime);
    }
}
