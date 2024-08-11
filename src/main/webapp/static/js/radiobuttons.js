// Function to handle radio button selection
function checkRadioButton() {
    // Get references to the radio buttons
    var unfollow = document.getElementById('unfollow');
    var follow = document.getElementById('follow');

    // Determine which radio button is selected
    if (unfollow.checked) {
        fetch(`/relationship/followedOrNot?status=`+0+`&userId=${userKey.id}`)
            .then(data => console.log('success'))
            .catch(error => console.error('Error:', error));
    } else if (follow.checked) {
        fetch(`/relationship/followedOrNot?status=`+1+`&userId=${userKey.id}`)
            .then(data => console.log('success'))
            .catch(error => console.error('Error:', error));
    }

    // Event listeners to both radio buttons
    document.getElementById('unfollow').addEventListener('click', checkRadioButton);
    document.getElementById('follow').addEventListener('click', checkRadioButton);

}
