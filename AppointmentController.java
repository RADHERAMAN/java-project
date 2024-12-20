import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/schedule")
    public Appointment schedule(@RequestBody Appointment appointment) {
        return appointmentService.scheduleAppointment(appointment);
    }
}
