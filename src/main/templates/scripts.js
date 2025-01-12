$(document).ready(function() {
    // Handle main menu clicks
    $('.nav-link').click(function(event) {
        event.preventDefault(); // Prevent default anchor behavior
        
        // Hide all sections
        $('.section').removeClass('show');
        $('.hidden-form').removeClass('show');
        
        // Get the target section ID from the href attribute
        var targetSectionId = $(this).attr('href');
        
        // Show the target section if it's not already visible
        if ($(targetSectionId).length) {
            $(targetSectionId).addClass('show');
        }
    });

    // Handle dropdown menu item clicks
    $('.dropdown-item').click(function(event) {
        event.preventDefault(); // Prevent default anchor behavior
        
        // Hide all forms
        $('.hidden-form').removeClass('show');
        
        // Get the target form ID from the href attribute
        var targetFormId = $(this).attr('href');
        
        // Show the target form if it's not already visible
        if ($(targetFormId).length) {
            $(targetFormId).addClass('show');
        }
    });

    // AJAX form submission for Registration & Login
    $('#registration-login-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            username: $('#username').val(),
            password: $('#password').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/registration-login', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Registration/Login successful!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred during registration/login.');
            }
        });
    });

    // AJAX form submission for Group
    $('#group-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            groupId: $('#group-id').val(),
            groupName: $('#group-name').val(),
            groupDescription: $('#group-description').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/group', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Group added successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while adding the group.');
            }
        });
    });

    // AJAX form submission for Role
    $('#role-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            roleId: $('#role-id').val(),
            roleName: $('#role-name').val(),
            salaryRange: $('#salary-range').val(),
            workTimings: $('#work-timings').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/role', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Role added successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while adding the role.');
            }
        });
    });

    // AJAX form submission for Health Condition
    $('#health-condition-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            conditionId: $('#condition-id').val(),
            conditionName: $('#condition-name').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/health-condition', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Health condition added successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while adding the health condition.');
            }
        });
    });

    // AJAX form submission for Health Status
    $('#health-status-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            statusId: $('#status-id').val(),
            statusName: $('#status-name').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/health-status', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Health status added successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while adding the health status.');
            }
        });
    });

    // AJAX form submission for Planting Report
    $('#planting-report-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            reportId: $('#report-id').val(),
            reportDetails: $('#report-details').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/planting-report', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Planting report added successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while adding the planting report.');
            }
        });
    });

    // AJAX form submission for Today's Watering Status
    $('#today-watering-status-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            wateringId: $('#watering-id').val(),
            wateringStatus: $('#watering-status').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/today-watering-status', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Today\'s watering status updated successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while updating today\'s watering status.');
            }
        });
    });

    // AJAX form submission for Tree Health Report
    $('#tree-health-report-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            treeReportId: $('#tree-report-id').val(),
            treeReportDetails: $('#tree-report-details').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/tree-health-report', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Tree health report added successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while adding the tree health report.');
            }
        });
    });

    // AJAX form submission for Tree
    $('#tree-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            treeId: $('#tree-id').val(),
            treeName: $('#tree-name').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/tree', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Tree added successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while adding the tree.');
            }
        });
    });

    // AJAX form submission for Maintenance Schedule
    $('#maintenance-schedule-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            scheduleId: $('#schedule-id').val(),
            scheduleDetails: $('#schedule-details').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/maintenance-schedule', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Maintenance schedule added successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while adding the maintenance schedule.');
            }
        });
    });

    // AJAX form submission for QR Code
    $('#qrcode-form').submit(function(event) {
        event.preventDefault();
        
        const data = {
            qrcodeId: $('#qrcode-id').val(),
            qrcodeData: $('#qrcode-data').val()
        };
        
        $.ajax({
            url: 'https://your-api-endpoint/qrcode', // Replace with your endpoint
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('QR Code generated successfully!');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('An error occurred while generating the QR code.');
            }
        });
    });
});
