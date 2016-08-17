$(function() {
    $(".btn_project_replies").click(function () {
        $("#projectReplies .parent").val($(this).attr("project-replies"));
    });
});
