// ReservationController.java

import com.example.demo.Reservation.Reservation;
import com.example.demo.Reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getAllReservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations/all";
    }

    @GetMapping("/new")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservations/new";
    }

    @PostMapping("/new")
    public String makeReservation(@ModelAttribute Reservation reservation) {
        // Dodaj logikę do sprawdzania dostępności i dokonywania rezerwacji
        reservationService.makeReservation(reservation.getRoom(), reservation.getCheckInDate(), reservation.getCheckOutDate());
        return "redirect:/reservations";
    }

    @GetMapping("/cancel/{id}")
    public String cancelReservation(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            reservationService.cancelReservation(reservation);
        }
        return "redirect:/reservations";
    }
}
