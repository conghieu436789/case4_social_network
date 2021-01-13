
const URL_API = "http://localhost:8080/";
function updateUser(id){

    let href = "admin/user/find/"+id;


    $.ajax({
        type: "GET",
        url: URL_API+href,

        success: function (user){
                $('#idEdit').val(user.id);
                $('#usernameEdit').val(user.username)
                $('#passwordEdit').val(user.password);
                $('#fullNameEdit').val(user.fullName);
                $('#date_of_birthEdit').val(user.dateOfBirth);
                $('#genderEdit').val(user.gender);
                $('#createdDate').val(user.createdDate);
                $('#photoEdit').val(user.photo);
                $('#phoneEdit').val(user.phone);
                $('#mailEdit').val(user.mail);
                $('#addressEdit').val(user.address);
                $('#statusEdit').val(user.status);
                $('#submitEdit').prop('disabled', false);
        }
    });



    $('#editModal').modal();
}
function userDetails(id){

    let href = "admin/user/find/"+id;


    $.ajax({
        type: "GET",
        url: URL_API+href,

        success: function (user){
            $('#idEdit').val(user.id);
            $('#usernameEdit').val(user.username)
            $('#passwordEdit').val(user.password);
            $('#fullNameEdit').val(user.fullName);
            $('#date_of_birthEdit').val(user.dateOfBirth);
            $('#genderEdit').val(user.gender);
            $('#createdDate').val(user.createdDate);
            $('#photoEdit').val(user.photo);
            $('#phoneEdit').val(user.phone);
            $('#mailEdit').val(user.mail);
            $('#addressEdit').val(user.address);
            $('#statusEdit').val(user.status);
            $('#submitEdit').prop('disabled', true);
        }
    });



    $('#editModal').modal();
}
function deleteUser(id) {
    let href = "/admin/user/delete/"+id;

    $('#confirmDelete').attr('href',href);

    $('#deleteModal').modal();
}