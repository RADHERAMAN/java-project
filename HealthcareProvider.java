import javax.persistence.*;

@Entity
public class HealthcareProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialty;
    private String location;
    private String availability;  // Format: "Mon-Fri 9:00AM - 5:00PM"

    // Getters and setters
}
