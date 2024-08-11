
const checkbox = document.getElementById('cityVisited');
const label = document.getElementById('labelVisitedOrNot');

checkbox.addEventListener('change', function() {
    var statusField = this.checked ? 1 : 0;
    console.log("checked " + this.checked);
    if (this.checked) {
        label.textContent = 'Visited';
        console.log("Visited")
    } else {
        label.textContent = 'Not visited';
        console.log("Not visited")
    }
    fetch(`/visitedcity/SaveAsVisitedCity?status=`+statusField+`&cityId=${cityKey.id}`, {})
        .then(data => {console.log('success', data);})
        .catch(error => console.error('Error:', error));

    console.log("checkbox.checked: " + checkbox.checked);
    console.log("statusField: " + statusField);

});
