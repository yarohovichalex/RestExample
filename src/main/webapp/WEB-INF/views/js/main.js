
/*const data = {
    articles: [
        { id: '1', image: 'http://via.placeholder.com/350x150', title: 'Article1', content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.' },
        { id: '2', image: 'http://via.placeholder.com/350x150', title: 'Article2', content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.' }
    ]
};*/

const doc = document;

function createArticle(data, admin) {
    let article = doc.createElement('article');
    article.id = data.id;
    let title = doc.createElement('h3');
    title.innerHTML = data.title;
    let img = doc.createElement('img');
    img.src = data.imagePath;
    img.setAttribute('alt', data.title);
    let content = doc.createElement('p');
    content.innerHTML = data.content;
    article.appendChild(title);
    article.appendChild(img);
    if(admin) {
        let deleteButton = doc.createElement('a');
        deleteButton.innerHTML = 'Delete';
        deleteButton.setAttribute('data-id', data.id);
        deleteButton.addEventListener('click', deleteArticle);
        article.appendChild(deleteButton);
    }
    article.appendChild(content);
    return article;
}

function addToPage(articleNode) {
    let articlesWrapper = doc.getElementById('articles-wrapper');
    let elemWrapper = doc.createElement('li');
    elemWrapper.appendChild(articleNode);
    articlesWrapper.appendChild(elemWrapper);
}

function deleteArticle(e) {
    e.preventDefault();
    const elem = e.currentTarget;
    const id = elem.getAttribute('data-id');
    const url = `http://localhost:8080/RestExample/restt/articl/${id}`;
    let xhr = new XMLHttpRequest();
    xhr.open('DELETE', url, false);
    xhr.send();

    if (xhr.status !== 200) {
        console.log('Server error!');
    } else {
        document.getElementById(id).parentNode.removeChild(document.getElementById(id));
    }
}

function createContent(admin) {
    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'http://localhost:8080/RestExample/restt/articl', false);

    xhr.send();

    if (xhr.status !== 200) {
        console.log('Server error!');
    } else {
        let response = xhr.responseText;
        response = JSON.parse(response);
        response.articles.forEach((article) => {
            let articleNode = createArticle(article, admin);
            addToPage(articleNode);
        })
    }
}