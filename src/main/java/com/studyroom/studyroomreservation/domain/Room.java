package com.studyroom.studyroomreservation.domain;

import lombok.Data;

@Data
public class Room {
    private Long roomId;
    private String name;
    private String location;
    private Integer capacity;
}
