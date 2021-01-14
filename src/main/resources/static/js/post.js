
const URL_API = "http://localhost:8080/";
function updatePost(id){

    let href = "admin/post/find/"+id;


    $.ajax({
        type: "GET",
        url: URL_API+href,

        success: function (post){
            $('#idEdit').val(post.id);
            $('#titleEdit').val(post.title)
            $('#createdDateEdit').val(post.createdDate);
            $('#modifyDateEdit').val(post.modifyDate);
            $('#contentEdit').val(post.content);
            $('#descriptionEdit').val(post.description);
            $('#commentIdEdit').val(post.commentId);
            $('#userIdEdit').val(post.userId);
            $('#submitEdit').prop('disabled', false);
        }
    });



    $('#editModal').modal();
}
function postDetails(id){

    let href = "admin/post/find/"+id;


    $.ajax({
        type: "GET",
        url: URL_API+href,

        success: function (post){
            $('#idEdit').val(post.id);
            $('#titleEdit').val(post.title)
            $('#createdDateEdit').val(post.createdDate);
            $('#modifyDateEdit').val(post.modifyDate);
            $('#contentEdit').val(post.content);
            $('#descriptionEdit').val(post.description);
            $('#commentIdEdit').val(post.commentId);
            $('#userIdEdit').val(post.userId);
            $('#user_name').val(getUsername(post.userId));
            console.log(getUsername(post.userId));
            $('#submitEdit').prop('disabled', true);
        }
    });



    $('#editModal').modal();
}
function deletePost(id) {
    let href = "/admin/post/delete/"+id;

    $('#confirmDelete').attr('href',href);

    $('#deleteModal').modal();
}

function getUsername(id){
    let href = "admin/user/find/"+id;
    $.ajax({
        type: "GET",
        url: URL_API+href,
        success: function (user){
            console.log(user.username);

            return user.username;

        }
    });
}