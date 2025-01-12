$(document).ready(function() {
    // Default to Home Section
    $('#home-section').show();
    $('.section').not('#home-section').hide();

    // Navigation Handling
    $('.nav-link').click(function(event) {
        event.preventDefault();

        // Remove 'active' class from all nav links
        $('.nav-link').removeClass('active');
        
        // Add 'active' class to the clicked nav link
        $(this).addClass('active');
        
        // Hide all sections
        $('.section').hide();
        
        // Show the target section
        var target = $(this).attr('href');
        $(target).show();
    });

    // Form Submissions
    $('#register-form').submit(function(event) {
        event.preventDefault();
        // Example: Handle registration form submission
        const data = {
            name: $('#register-name').val(),
            email: $('#register-email').val(),
            password: $('#register-password').val()
        };
        $.post('/api/register', data, function(response) {
            alert('Registration successful!');
            $('#register-form')[0].reset();
        }).fail(function() {
            alert('Error during registration.');
        });
    });

    $('#login-form').submit(function(event) {
        event.preventDefault();
        // Example: Handle login form submission
        const data = {
            email: $('#login-email').val(),
            password: $('#login-password').val()
        };
        $.post('/api/login', data, function(response) {
            alert('Login successful!');
            $('#login-form')[0].reset();
        }).fail(function() {
            alert('Error during login.');
        });
    });

    $('#tree-form').submit(function(event) {
        event.preventDefault();
        // Example: Handle tree form submission
        const data = {
            type: $('#tree-type').val(),
            name: $('#tree-name').val(),
            cost: $('#tree-cost').val()
        };
        $.post('/api/trees', data, function(response) {
            alert('Tree added successfully!');
            $('#tree-form')[0].reset();
        }).fail(function() {
            alert('Error adding tree.');
        });
    });

    $('#health-report-form').submit(function(event) {
        event.preventDefault();
        // Example: Handle health report form submission
        const data = {
            plantId: $('#report-plant-id').val(),
            healthStatus: $('#report-health-status').val()
        };
        $.post('/api/health-reports', data, function(response) {
            alert('Health report submitted successfully!');
            $('#health-report-form')[0].reset();
        }).fail(function() {
            alert('Error submitting health report.');
        });
    });

    $('#user-form').submit(function(event) {
        event.preventDefault();
        // Example: Handle user form submission
        const data = {
            name: $('#user-name').val(),
            email: $('#user-email').val()
        };
        $.post('/api/users', data, function(response) {
            alert('User added successfully!');
            $('#user-form')[0].reset();
        }).fail(function() {
            alert('Error adding user.');
        });
    });

    $('#location-form').submit(function(event) {
        event.preventDefault();
        // Example: Handle location form submission
        const data = {
            latitude: $('#location-latitude').val(),
            longitude: $('#location-longitude').val(),
            altitude: $('#location-altitude').val()
        };
        $.post('/api/locations', data, function(response) {
            alert('Location added successfully!');
            $('#location-form')[0].reset();
        }).fail(function() {
            alert('Error adding location.');
        });
    });

    $('#watering-status-form').submit(function(event) {
        event.preventDefault();
        // Example: Handle watering status form submission
        const data = {
            plantId: $('#watering-plant-id').val(),
            lastWatered: $('#watering-last-watered').val()
        };
        $.post('/api/watering-status', data, function(response) {
            alert('Watering status updated successfully!');
            $('#watering-status-form')[0].reset();
        }).fail(function() {
            alert('Error updating watering status.');
        });
    });

    // Example function to load report data
    function loadReport() {
        $.get('/api/upcoming-plants-report', function(data) {
            var html = '<ul>';
            data.forEach(function(report) {
                html += '<li>' + report.name + ': ' + report.totalPlantsAvailable + ' available</li>';
            });
            html += '</ul>';
            $('#report-content').html(html);
        }).fail(function() {
            $('#report-content').html('<p>Error loading report.</p>');
        });
    }
});
