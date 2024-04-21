async function registerUser() {
    const modalName = 'login';

    var username = $(`.modal#${modalName} input#username`).val();
    var password = $(`.modal#${modalName} input#password`).val();

    // confirmação de senha


    if (username == '' || password == '') {
        errorMessage('Preencha todos os campos');
        return;
    }

    const result = await createUser(username, password);

    if (result.status == 'error') {
        errorMessage(result.message)
        return;
    }
    

    saveUserId(result.message);
    $(`.modal#${modalName}`).modal('hide');

    $(`.modal#${modalName} input#username`).val('');
    $(`.modal#${modalName} input#password`).val('');

    drawNotes();
}


async function auth() {
    const modalName = 'login';

    var username = $(`.modal#${modalName} input#username`).val();
    var password = $(`.modal#${modalName} input#password`).val();

    if (username == '' || password == '') {
        errorMessage('Preencha todos os campos');
        return;
    }

    const result = await loginUser(username, password);

    if (result.status == 'error') {
        errorMessage(result.message)
        return;
    }

    saveUserId(result.message);
    $(`.modal#${modalName}`).modal('hide');

    $(`.modal#${modalName} input#username`).val('');
    $(`.modal#${modalName} input#password`).val('');

    drawNotes();
}



function logout() {
    localStorage.removeItem('user_id');
    // clear Notes
    $('#cards-container .container').html('');
    openModal('login');
}


function saveUserId(user_id) {
    localStorage.setItem('user_id', user_id);
}





function authAction() {
    const modalName = 'login';

    if ($(`.modal#${modalName}`)[0].dataset.type == 'auth') {        
        auth();
    }
    else {
        registerUser();
    }
}


function changeAuthForm() {
    const modalName = 'login';

    if ($(`.modal#${modalName}`)[0].dataset.type == 'auth') {
        $(`.modal#${modalName}`)[0].dataset.type = 'register';
        return;
    }
    
    $(`.modal#${modalName}`)[0].dataset.type = 'auth';
}


function errorMessage(message) {
    const modalName = 'login';

    $(`.modal#${modalName} .alert-message #error-message`).html(message);
    $(`.modal#${modalName} .alert-message`)[0].style.display = 'block';
    setTimeout(() => {
        $(`.modal#${modalName} .alert-message`)[0].style.display = 'none';
    }, 3000);
}

