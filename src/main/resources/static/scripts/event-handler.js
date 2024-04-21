function openModal(modalName, callback = function() {}) {
    $(`.modal#${modalName}`).modal(`show`);
    try {
        $(`.modal#${modalName} button#yes`)[0].onclick = callback;
    } catch (e) {}
}
function closeModal(modalName) {
    $(`.modal#${modalName}`).modal(`hide`);
}



function deleteNote(noteId) {
    modalName = 'delete-task';

    const user_id = localStorage.getItem('user_id');
    openModal(modalName, function() {
        deleteTask(user_id, noteId);
        closeModal(modalName);
        drawNotes();
    });
}


function createNote() {
    const modalName = 'create-task';
    const user_id = localStorage.getItem('user_id');

    $(`.modal#${modalName} .done-box`).css('display', 'none');
    $(`.modal#${modalName} button#yes`).html('Criar Nota');


    const title_input = $(`.modal#${modalName} input#title`)
    const body_input = $(`.modal#${modalName} textarea#description`)
    const endline_input = $(`.modal#${modalName} input#date`)

    title_input.val('');
    body_input.val('');
    endline_input.val('');

    openModal(modalName, function() {
        title = title_input.val();
        body = body_input.val();
        endline = endline_input.val();

        if (!validateTaskForm(title, body)) return;
                
        endline = endline ? new Date(endline).toISOString() : null;
        createTask(user_id, {
            title,
            body,
            endline
        });
        closeModal(modalName);

        setTimeout(() => {
            drawNotes();
        }, 1000);
    });
}


function updateNote(noteId, title, body, endline, done) {
    const modalName = 'create-task';
    const user_id = localStorage.getItem('user_id');


    $(`.modal#${modalName} .done-box`).css('display', 'flex');
    $(`.modal#${modalName} button#yes`).html('Atualizar nota');

    const title_input = $(`.modal#${modalName} input#title`);
    const body_input = $(`.modal#${modalName} textarea#description`);
    const endline_input = $(`.modal#${modalName} input#date`);
    const done_input = $(`.modal#${modalName} input#done`);

    title_input.val(title);
    body_input.val(body);
    try {
        endline_input.val(new Date(endline).toJSON().split('T')[0]);
    } catch (e) {
        endline_input.val('');
    }
    done_input[0].checked = done == 'completo' ? true : false;
    
    openModal(modalName, function() {
        title = title_input.val();
        body = body_input.val();
        endline = endline_input.val();
        done = done_input[0].checked;

        if (!validateTaskForm(title, body)) return;
                
        endline = endline ? new Date(endline).toISOString() : null;
        updateTask(user_id, noteId, {
            title,
            body,
            endline,
            status: done ? 'completo' : 'incompleto',
        });
        closeModal(modalName);

        setTimeout(() => {
            drawNotes();
        }, 1000);
    });
}



function validateTaskForm(title, body) {
    if (title === '' || body === '') {
        $('#create-task .alert-message')[0].style.display = 'block';
        setTimeout(() => {
            $('#create-task .alert-message')[0].style.display = 'none';
        }, 3000)
        return false;
    }
    return true;
}