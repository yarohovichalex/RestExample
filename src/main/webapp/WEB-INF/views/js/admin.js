document.addEventListener('DOMContentLoaded', () => createContent(true));

document.getElementById('create-article-form').addEventListener('submit', addArticle);

function addArticle(e) {
    e.preventDefault();
    const title = doc.getElementById('title').value;
    const image = doc.getElementById('image').value;
    const content = doc.getElementById('content').value;
    const data = {
        title,
        image,
        content
    };
    let xhr = new XMLHttpRequest(); 
    xhr.open('POST', 'http://localhost:8080/RestExample/restt/admin_page', false);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(data));
    if (xhr.status !== 200) {
        console.log( xhr.status + ': ' + xhr.statusText);
    } else {
        let response = xhr.responseText;
        response = JSON.parse(response);
        addToPage(createArticle(response, true));
    }
}