async function drawNotes() {
    const user_id = localStorage.getItem('user_id');
    const notes = await getTasks(user_id);

    $('#cards-container .container').html('');
    notes.forEach(note => {
        endline_title = note.endline ? new Date(note.endline).toGMTString().slice(5,16) : false;

        $('#cards-container .container').append(`
        <div class="task ${note.status == 'completo' ? 'done' : ''}">
            <div class="task-header">
                <h4>${note.title}</h4>

                <div class="action-buttons">
                    <span title="Editar Nota" class="edit-task button" onclick="updateNote('${note.id}', '${note.title}','${note.body}','${note.endline}','${note.status}',)"></span>
                    <span title="Deletar Nota" class="delete-task button" onclick="deleteNote('${note.id}')"></span>
                </div>
            </div>
            <div class="task-body">
                <p>${note.body}</p>
            </div>

            ${
                (!note.endline ? '' : `
                <div class="task-footer">
                    <span class="icon material-symbols-outlined">schedule</span>
                    <span class="date-detail">${endline_title}</span>
                </div>`)
            }
        </div>
        `);
    });
}