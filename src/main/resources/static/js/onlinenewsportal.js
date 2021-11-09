function handleSwitching() {
    let checkbox = document.getElementById('darkModeCheckbox');
    checkbox.addEventListener('change', e => {
        let body = document.body;
        if (e.target.checked) {
            body.classList.add("dark-mode");
        } else {
            body.classList.remove("dark-mode");
        }
    });
}

const ZIP_EXTENSION = ".zip";
const CHECK_EXTENSION_MESSAGE = "Sorry, it's not a zip file";

function checkFileExtension() {
    let element = document.getElementById("inputFile");
    let file = element.files[0];
    if (!file.name.endsWith(ZIP_EXTENSION)) {
        window.alert(CHECK_EXTENSION_MESSAGE);
        element.value = null;
    } else {
        let button = document.getElementById("buttonLoad");
        button.disabled = false;
    }
}