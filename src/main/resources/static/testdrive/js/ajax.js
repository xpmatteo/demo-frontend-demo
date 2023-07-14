$.ajaxSetup({
    complete: hideSpinners,
});

export function hideSpinners() {
    $(".spinner").hide()
}

export function indent(json) {
    return JSON.stringify(json, null, 2)
}
