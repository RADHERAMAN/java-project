// Handle user registration
document.getElementById("registrationForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const email = document.getElementById("email").value;

    // Make an API call to register the user (assuming backend endpoint is set)
    fetch('http://localhost:8080/users/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password,
            email: email
        })
    })
    .then(response => response.json())
    .then(data => {
        alert("User registered successfully!");
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Registration failed!");
    });
});

// Handle user login
document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const username = document.getElementById("loginUsername").value;
    const password = document.getElementById("loginPassword").value;

    // Make an API call to login the user
    fetch('http://localhost:8080/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data) {
            alert("Login successful!");
            // Redirect to dashboard or another page
        } else {
            alert("Invalid credentials.");
        }
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Login failed!");
    });
});

// Fetch healthcare providers and populate the provider dropdown
window.onload = function() {
    fetchHealthcareProviders();
};

function fetchHealthcareProviders() {
    fetch('http://localhost:8080/providers/search?specialty=general&location=NewYork')
    .then(response => response.json())
    .then(data => {
        const providerSelect = document.getElementById("provider");
        providerSelect.innerHTML = ''; // Clear previous options

        data.forEach(provider => {
            const option = document.createElement("option");
            option.value = provider.id;
            option.textContent = `${provider.name} (${provider.specialty})`;
            providerSelect.appendChild(option);
        });
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Failed to fetch healthcare providers.");
    });
}

// Handle appointment scheduling
document.getElementById("appointmentForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const providerId = document.getElementById("provider").value;
    const appointmentType = document.getElementById("appointmentType").value;
    const appointmentDate = document.getElementById("appointmentDate").value;

    // Make an API call to schedule the appointment
    fetch('http://localhost:8080/appointments/schedule', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            providerId: providerId,
            appointmentType: appointmentType,
            appointmentTime: appointmentDate
        })
    })
    .then(response => response.json())
    .then(data => {
        alert("Appointment scheduled successfully!");
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Failed to schedule appointment.");
    });
});
