import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class HealthcareProviderController {

    @Autowired
    private HealthcareProviderService providerService;

    @GetMapping("/search")
    public List<HealthcareProvider> searchProviders(@RequestParam String specialty, @RequestParam String location) {
        return providerService.searchHealthcareProviders(specialty, location);
    }
}
