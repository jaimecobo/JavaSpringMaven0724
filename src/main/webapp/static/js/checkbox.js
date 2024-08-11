function updateStatus() {
    var checkbox = document.getElementById('visitedCheckbox');
    var statusField = document.getElementById('statusField');

    // Set the hidden field value based on the checkbox status
    statusField.value = checkbox.checked ? 'true' : 'false';

    // Prevent the form from being submitted normally
    event.preventDefault();

    // Use Fetch API to send the data asynchronously
    fetch('/visitedcity/SaveAsVisitedCity', {
        method: 'POST',
        body: JSON.stringify({status: statusField.value}),
        headers: {'Content-Type': 'application/json'}
    })
        .then(response => response.text())
        .then(data => console.log(data))
        .catch(error => console.error('Error:', error));
}
