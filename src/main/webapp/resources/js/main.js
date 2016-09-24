$(function() {
    $(".btn_project_replies").click(function () {
        $("#replies .parent").val($(this).attr("project-replies"));
    });
    $(".deleted_image").click(function () {
        var image_id = $(this).attr("image_id");
        $.ajax({
            url: '/project/deleted-image/' + image_id, // point to server-side PHP script
            cache: false,
            contentType: false,
            processData: false,
            type: 'get',
            success: function(response){
                alert(response);
                location.reload();

            },
            error : function(error) {
                alert(error);
                console.log('error: ', error);
            }
        });
    });

});


var edit = {
    showUploadDialog : function() {
        $('#photoUploaderBox').modal({
            show : true
        });
        return false;
    },


    uploadPhoto : function () {
        var file_data = $('#photoFile').prop('files')[0];
        var form_data = new FormData();
        form_data.append('photoFile', file_data);
        $.ajax({
            url: '/user-profile-photo', // point to server-side PHP script
            //dataType: 'json',  // what to expect back from the PHP script, if anything
            cache: false,
            contentType: false,
            processData: false,
            data: form_data,
            type: 'post',
            success: function(response){
                alert(response);
                location.reload();

            },
            error : function(error) {
                alert(error);
                console.log('error: ', error);
            }
        });

    },
    addImage : function () {
        var image = $('#image').prop('files')[0];
        var id = $('#project_id').val();
        var form_data = new FormData();
        form_data.append('image', image);
        $.ajax({
            url: '/project/add-image/' + id, // point to server-side PHP script
            cache: false,
            contentType: false,
            processData: false,
            data: form_data,
            type: 'post',
            success: function(response){
                alert(response);
                location.reload();

            },
            error : function(error) {
                alert(error);
                console.log('error: ', error);
            }
        });
    }
};