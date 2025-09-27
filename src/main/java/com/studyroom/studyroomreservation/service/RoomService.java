package com.studyroom.studyroomreservation.service;

import com.studyroom.studyroomreservation.domain.Room;
import com.studyroom.studyroomreservation.repository.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomMapper roomMapper;

    //예약 가능한 방 조회
    public List<Room> getAvailableRooms(LocalDate date) {
        return roomMapper.findAvailableRooms(date);
    }

    // 방 등록
    public void createRoom(Room room) {
        roomMapper.insertRoom(room);
    }

}
