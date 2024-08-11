
document.getElementById('unfollow').addEventListener('click', function(){
    if (this.checked) {
        fetch(`/relationship/followedOrNot?status=`+0+`&userId=${userKey.id}`)
            .then(data => console.log('success unfollowing'))
            .catch(error => console.error('Error:', error));
    }
});

document.getElementById('follow').addEventListener('click', function(){
    if (this.checked) {
        fetch(`/relationship/followedOrNot?status=`+1+`&userId=${userKey.id}`)
            .then(data => console.log('success following'))
            .catch(error => console.error('Error:', error));
    }
});
