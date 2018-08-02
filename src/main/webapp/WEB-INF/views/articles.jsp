<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Articles</title>
    <style>
    	li {  
			list-style: none;	
		}
		
		img {
			display: block;
		}
		
		input {
			display: block;
			padding: 5px;
			border-radius: 5px;
			margin: 10px 0;
		}
		
		a {
			display: inline-block;
			margin-top: 10px;
			cursor: pointer;
		}
		
		#articles-wrapper {
			padding: 0;
			margin: 0;
		}
		
		input[type=submit] {
			cursor: pointer;
		}
    </style>
</head>
<body>
    <div id="main">    
        <ul id="articles-wrapper"></ul>
    </div>
    <script>
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
	        const url = `/article/${id}`;
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
	
	        xhr.open('GET', '/RestExample/article/', false);
	
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
	    document.addEventListener('DOMContentLoaded', () => createContent());
    </script>
</body>
</html>