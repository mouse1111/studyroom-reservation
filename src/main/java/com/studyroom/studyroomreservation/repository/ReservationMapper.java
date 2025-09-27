package com.studyroom.studyroomreservation.repository;

import com.studyroom.studyroomreservation.domain.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ReservationMapper {
    //예약 생성
    void insertReservation(Reservation reservation);

    //특정 시간대 예약 조회
    List<Reservation> findReservationsByRoomAndTime(@Param("roomId") Long roomId,
                                                    @Param("startAt") LocalDateTime startAt,
                                                    @Param("endAt") LocalDateTime endAt);
    //예약 삭제
    void deleteReservationById(Long reservationId); //예약 취소

    Reservation findReservationById(@Param("reservationId") Long reservationId);

}
