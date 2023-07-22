import { indent } from "./ajax.js";

function cleanUp() {
    $("#search-output").val();
}

export function searchRequest() {
    cleanUp();
    $("#search-spinner").show()
    const method = $("#search-method").val();
    const data = $("#search-input").val();
    $.ajax({
        method,
        data,
        contentType: "application/json",
        url: $("#search-path").val(),
        success: onSearchSuccess,
        error: onSearchError,
    });
}

export function onSearchError(jq) {
    const d = jq.responseJSON ? jq.responseJSON : jq;
    $("#search-output").removeClass("success").addClass("error").val(indent(d));
}

function onSearchSuccess(content, textStatus, jq) {
    $("#search-output").removeClass("error").addClass("success").val(indent(content));
}