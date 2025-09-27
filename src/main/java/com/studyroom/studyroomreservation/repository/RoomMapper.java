package com.studyroom.studyroomreservation.repository;

import com.studyroom.studyroomreservation.domain.Room;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface RoomMapper {
    void insertRoom(Room room); //회의실 등록
    List<Room> findAvailableRooms(LocalDate date); //특정 날짜 예약 조회
}
