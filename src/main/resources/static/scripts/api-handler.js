function getTasks(userId) {
    return fetch(`/users/${userId}/tasks`)
        .then(response => response.json());
}

function createTask(userId, task) {
    return fetch(`/users/${userId}/tasks`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(task)
    });
}

function updateTask(userId, taskId, task) {
    return fetch(`/users/${userId}/tasks/${taskId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(task)
    });
}

function deleteTask(userId, taskId) {
    return fetch(`/users/${userId}/tasks/${taskId}`, {
        method: 'DELETE'
    });
}