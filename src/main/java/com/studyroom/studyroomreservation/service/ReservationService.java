package com.studyroom.studyroomreservation.service;

import com.studyroom.studyroomreservation.domain.Reservation;
import com.studyroom.studyroomreservation.repository.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationMapper reservationMapper;

    //예약 생성
    @Transactional
    public void createReservation(Reservation reservation) {
        // 겹치는 예약 있는지 확인
        List<Reservation> existing = reservationMapper.findReservationsByRoomAndTime(
                reservation.getRoomId(),
                reservation.getStartAt(),
                reservation.getEndAt()
        );

        if (!existing.isEmpty()) {
            throw new IllegalArgumentException("해당 시간대는 이미 예약되어 있습니다.");
        }

        reservationMapper.insertReservation(reservation);
    }

    //예약 취소
    @Transactional
    public void cancelReservation(Long reservationId) {
        reservationMapper.deleteReservationById(reservationId);
    }

    // 단일 예약 조회 (RBAC용)
    @Transactional(readOnly = true)
    public Reservation getReservationById(Long reservationId) {
        return reservationMapper.findReservationById(reservationId);
    }
}
