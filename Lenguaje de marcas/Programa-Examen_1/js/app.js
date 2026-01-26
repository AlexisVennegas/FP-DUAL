let initialCode = `
<h1>aqui escribes html</h1>
<p>Estoy practicando lenguaje de marcas</p>
`;

let preview = document.getElementById("preview");
function updatePreview(code) {
    preview.srcdoc = code;
}

// Cargar último guardado
let saved = localStorage.getItem("editorAutoSave");
if (saved) initialCode = saved;

// Crear CodeMirror 5 (más estable)
let editor = CodeMirror.fromTextArea(document.getElementById("editor"), {
    mode: "htmlmixed",
    lineNumbers: true,
    theme: "default",
    tabSize: 2
});

editor.setValue(initialCode);

// Auto guardar + auto ejecutar
editor.on("change", () => {
    let code = editor.getValue();
    updatePreview(code);
    localStorage.setItem("editorAutoSave", code);
});

// refrescar vista inicial
updatePreview(initialCode);
