// thanks https://youmightnotneedjquery.com/
export async function ajax({
                               spinnerId,
                               method,
                               data,
                               path,
                               output,
                               colorize = false,
                           }) {
    show(spinnerId);
    const outputElement = document.getElementById(output);
    outputElement.value = '';
    try {
        const response = await fetch(find(path), {
            method: find(method),
            body: find(data),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        if (colorize) updateColor(outputElement, response.ok);
        outputElement.value = indent(parse(await response.text()));
    } catch (ex) {
        if (colorize) updateColor(outputElement, false);
        outputElement.value = ex;
    } finally {
        hide(spinnerId);
    }
}

/**
 * @param elementIdOrLiteral {string}
 * @returns {string}
 */
function find(elementIdOrLiteral) {
    const element = document.getElementById(elementIdOrLiteral);
    if (element) {
        return element.value;
    }
    return elementIdOrLiteral;
}

function updateColor(helloOutput, ok) {
    if (!ok) {
        helloOutput.classList.remove("success");
        helloOutput.classList.add("error");
    } else {
        helloOutput.classList.add("success");
        helloOutput.classList.remove("error");
    }
}

export function indent(json) {
    return JSON.stringify(json, null, 2)
}

function parse(string) {
    return JSON.parse(string);
}

function show(elementId) {
    document.getElementById(elementId).style.display = '';
}

function hide(elementId) {
    document.getElementById(elementId).style.display = 'none';
}
