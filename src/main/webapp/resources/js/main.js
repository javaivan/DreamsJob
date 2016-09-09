$(function() {
    $(".btn_project_replies").click(function () {
        $("#replies .parent").val($(this).attr("project-replies"));
    });
});
