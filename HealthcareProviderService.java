import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthcareProviderService {

    @Autowired
    private HealthcareProviderRepository providerRepository;

    public List<HealthcareProvider> searchHealthcareProviders(String specialty, String location) {
        return providerRepository.findBySpecialtyAndLocation(specialty, location);
    }
}
