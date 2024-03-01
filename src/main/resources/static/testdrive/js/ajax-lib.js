// thanks https://youmightnotneedjquery.com/
export async function ajax({
                               spinnerId,
                               method,
                               data,
                               path,
                               target,
                               colorize = false,
                           }) {
    show(spinnerId);
    const targetElement = document.getElementById(target);
    targetElement.value = '';
    try {
        const response = await fetch(find(path), {
            method: find(method),
            body: find(data),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        if (colorize) updateColor(targetElement, response.ok);
        targetElement.value = indent(parse(await response.text()));
    } catch (ex) {
        if (colorize) updateColor(targetElement, false);
        targetElement.value = ex;
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

function updateColor(element, ok) {
    if (!ok) {
        element.classList.remove("success");
        element.classList.add("error");
    } else {
        element.classList.add("success");
        element.classList.remove("error");
    }
}

export function indent(json) {
    return JSON.stringify(json, null, 2)
}

function parse(string) {
    return JSON.parse(string);
}

function show(elementId) {
    const element = document.getElementById(elementId);
    if (element) {
        element.style.display = '';
    }
}

function hide(elementId) {
    const element = document.getElementById(elementId);
    if (element) {
        element.style.display = 'none';
    }
}
