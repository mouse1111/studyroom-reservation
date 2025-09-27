package com.studyroom.studyroomreservation.controller;

import com.studyroom.studyroomreservation.domain.Room;
import com.studyroom.studyroomreservation.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/rooms")
@RestController
public class RoomController {
    private final RoomService roomService;

    //스터디룸 예약
    @PostMapping
    public ResponseEntity<String> createRoom(@RequestBody Room room,
                                             @RequestHeader("Authorization") String token) {
        if (!"admin-token".equals(token)) {
            return ResponseEntity.status(403).body("권한이 없습니다.");
        }

        roomService.createRoom(room);
        return ResponseEntity.ok("회의실 등록 성공");
    }

    //예약 가능 방 조회
    @GetMapping
    public ResponseEntity<List<Room>> getAvailableRooms(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Room> rooms = roomService.getAvailableRooms(date);
        return ResponseEntity.ok(rooms);
    }
}
