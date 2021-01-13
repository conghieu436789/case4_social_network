function deletePost(id) {
    let href = "/admin/post/delete/"+id;

    $('#confirmDelete').attr('href',href);

    $('#deleteModal').modal();
}

const URL_API = "http://localhost:8080/";
function viewPost(id){

    let href = "admin/post/find/"+id;
    $.ajax({
        type: "GET",
        url: URL_API+href,
        success: function (post){
            ;
            $('#idEdit').val(post.postId);
            $('#titleEdit').val(post.title);
            $('#usernameEdit').val(post.userId);
            $('#createdDateEdit').val(post.createdDate);
            $('#contentEdit').val(post.content);
            $('#photoEdit').val(post.photo);
            $('#videoEdit').val(post.video);
            $('#commentIdEdit').val(post.commentId);
            $('#descriptionEdit').val(post.description);

        }
    });

    $('#editModal').modal();
}

function getUsername(id){
    let href = "admin/user/find/"+id;
        $.ajax({
            type: "GET",
            url: URL_API+href,
            success: function (user){
                console.log(abc);
                abc = user.username;

                return user.username;

            }
        });
}