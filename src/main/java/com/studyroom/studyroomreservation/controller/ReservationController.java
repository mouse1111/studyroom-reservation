package com.studyroom.studyroomreservation.controller;

import com.studyroom.studyroomreservation.domain.Reservation;
import com.studyroom.studyroomreservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    // 예약 생성
    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation,
                                                    @RequestHeader("Authorization") String token) {
        if (!token.startsWith("user-token-")) {
            return ResponseEntity.status(403).body("권한이 없습니다.");
        }

        // 토큰에서 userId 추출
        String userId = token.substring("user-token-".length());
        reservation.setUserId(userId);

        reservationService.createReservation(reservation);
        return ResponseEntity.ok("예약이 성공적으로 생성되었습니다.");
    }

    // 예약 취소
    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelReservation(@PathVariable("id") Long reservationId,
                                                    @RequestHeader("Authorization") String token) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        if (reservation == null) {
            return ResponseEntity.status(404).body("예약을 찾을 수 없습니다.");
        }

        String userIdFromToken = token.startsWith("user-token-")
                ? token.substring("user-token-".length())
                : null;

        boolean isAdmin = "admin-token".equals(token);
        boolean isOwner = userIdFromToken != null && userIdFromToken.equals(reservation.getUserId());

        if (!isAdmin && !isOwner) {
            return ResponseEntity.status(403).body("권한이 없습니다.");
        }


        reservationService.cancelReservation(reservationId);
        return ResponseEntity.ok("예약이 취소되었습니다.");
    }
}
