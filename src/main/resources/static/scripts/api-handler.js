
function createUser(username, password) {
    return fetch('/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username,
            password,
        })
    }).then(response => response.json());
}

function loginUser(username, password) {
    return fetch('/auth', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username,
            password,
        })
    }).then(response => response.json());
}


function getTasks(userId) {
    return fetch(`/user/${userId}/tasks`)
        .then(response => response.json());
}

function createTask(userId, task) {
    return fetch(`/user/${userId}/tasks`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(task)
    });
}

function updateTask(userId, taskId, task) {
    return fetch(`/user/${userId}/tasks/${taskId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(task)
    });
}

function deleteTask(userId, taskId) {
    return fetch(`/user/${userId}/tasks/${taskId}`, {
        method: 'DELETE'
    });
}