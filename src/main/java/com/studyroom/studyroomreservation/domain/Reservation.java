package com.studyroom.studyroomreservation.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reservation {
    private Long reservationId;
    private Long roomId;
    private String userId;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}

