import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long providerId;
    private LocalDateTime appointmentTime;
    private String consultationType;  // E.g., "TEXT", "AUDIO", "VIDEO"

    // Getters and setters
}
