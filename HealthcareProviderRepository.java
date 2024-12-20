import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider, Long> {
    List<HealthcareProvider> findBySpecialty(String specialty);
    List<HealthcareProvider> findByLocation(String location);
}
