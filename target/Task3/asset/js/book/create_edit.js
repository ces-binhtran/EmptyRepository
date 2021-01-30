const authorListSearchEle = document.getElementById("author_list_dropdown");
const authorListEle = document.getElementById("author_list");
const inputSearch = document.getElementById("author_input_search");
const form = document.getElementById("form");
const nameInput = form["name"];
const typeSelect = form["type"];
const imageInput = form["image"];
let _authorsOfBook = [];
let _allAuthor = [];
let currentAuthor  = [];
let showAuthorListSearch  = false;
const rootURL = "http://localhost:8080/";
const rootAPI = "http://localhost:8080/api";
const bookId = document.getElementById("bookId").getAttribute("value");
const jsonHeaderConfig = {
    'Content-Type': 'application/json',
    'Accept': 'application/json'
}

// ---------------------Event-----------------------

window.addEventListener("click", (event) => {
    if(event.target !== inputSearch && event.target !== authorListSearchEle ){
        inputSearch.value = ""
        clearDropDownSearch()
    }
})

function onInputHandler (target) {
    const value = target.value;
    let temp =[];
    if(value !== ""){
        temp = _allAuthor
            .filter(author => author.name.toLocaleLowerCase().includes(value.toLocaleLowerCase()))
            .filter(author => !currentAuthor.some(ele  => ele.id === author.id))
    }else{
        temp = [];
    }
    renderSelectBox(temp);
}

function onAddAuthorToBook(data){

    currentAuthor.push(data);
    clearDropDownSearch();
    inputSearch.value = ""
    const author = document.createElement("li");
    author.id = data.id;
    let classList = "list-group-item d-flex justify-content-between align-items-center";
    addClassListToElement(author, classList.split(" "));
    author.append(document.createTextNode(data.name));

    const removeButton = document.createElement("button");
    removeButton.type = "button"
    removeButton.append(document.createTextNode("X"));
    classList = "list-group-item d-flex justify-content-between align-items-center";
    addClassListToElement(removeButton, classList.split(" "))
    removeButton.onclick = function (){
        onRemoveAuthorFromBook(data.id);
    }

    author.append(removeButton);
    authorListEle.append(author)
}



function onRemoveAuthorFromBook(authorId){
    currentAuthor = currentAuthor.filter(ele => ele.id != authorId);
    const authorItemElements =  authorListEle.children;
    const ele  = [...authorItemElements].find(ele => ele.id == authorId);
    ele.remove();
}

function validation(){
    if(!nameInput.value || typeSelect.value == 0) return false;
    return true;
}

function onSummitFormHandler(){
    onSubmitForm().then(r => window.location.replace("/"));
}

async function onSubmitForm(){
    if(validation()){
        const name = nameInput.value;
        const type = typeSelect.value;
        const addedAuthorIds = currentAuthor
            .filter(author => !_authorsOfBook.some(ele => ele.id == author.id))
            .map(ele => ele.id);
        const deleteAuthorIds = _authorsOfBook
            .filter(author => !currentAuthor.some(ele => ele.id == author.id))
            .map(ele => ele.id);
        if(bookId){
            return await Promise.all([
                editBook(bookId, name, type),
                addAuthorsToBook(bookId, addedAuthorIds),
                deleteAuthorsFromBook(bookId, deleteAuthorIds)
            ])
        }else{
            const res = await createBook(name, type);
            return await Promise.all([
                addAuthorsToBook(res.id, addedAuthorIds),
                deleteAuthorsFromBook(res.id, deleteAuthorIds)
            ])
        }
    }
}


// --------------------Util-------------------
function addClassListToElement(element, classList){
    classList.forEach(ele => element.classList.add(ele));
}

// ---------------------Ajax call---------------

async function fetchAuthor(){
    const resultJson  = await fetch(`${rootAPI}/author`, {
        method: "get",
    })
    return await resultJson.json()
}

async function fetchAuthorOfBook(bookId){
    const resultJson = await fetch(`${rootAPI}/author/book/${bookId}`, {
        method: "get"
    });
    return await resultJson.json();
}
async function createBook(name, type){
    const resultJson = await fetch(`${rootAPI}/book/create`,{
        method: "post",
        headers: jsonHeaderConfig,
        body : JSON.stringify({name, type})
    })
    return await resultJson.json();
}

async function  editBook(id, name, type){
    const resultJson = await fetch(`${rootAPI}/book/edit`,{
        method: "post",
        headers: jsonHeaderConfig,
        body : JSON.stringify({id,name, type})
    })
    return await resultJson.json();
}
async function addAuthorsToBook(bookId, addedAuthorIds){
    const resultJson = await fetch(`${rootAPI}/author/book/${bookId}/add`,{
        method: "post",
        headers: jsonHeaderConfig,
        body: JSON.stringify(addedAuthorIds)
    })
    const json = await resultJson.json();
}

async function deleteAuthorsFromBook(bookId, deleteAuthorsIds){
    const resultJson = await fetch(`${rootAPI}/author/book/${bookId}/delete`,{
        method: "post",
        headers: jsonHeaderConfig,
        body: JSON.stringify(deleteAuthorsIds)
    })
    const json = await resultJson.json();
}
//-----------------------Other---------------------



function clearDropDownSearch() {
    while (authorListSearchEle.lastElementChild) {
        authorListSearchEle.removeChild(authorListSearchEle.lastElementChild);
    }
}


function renderSelectBox(data){
    clearDropDownSearch();
    data.forEach(ele => authorListSearchEle.append(createAuthorItem(ele)))

}
function createAuthorItem(data){
    const item = document.createElement("li");
    item.onclick = function (){
        onAddAuthorToBook(data);
    };
    addClassListToElement(item,
        ["list-group-item", "list-group-item-action", "list-group-item-primary"])
    item.style.width = "100%"
    item.style.cursor ="pointer"
    item.append(document.createTextNode(data.name));
    return item;
}

function main(){
    if(bookId){
        //edit mode
        fetchAuthorOfBook(bookId).then(res => {
            _authorsOfBook = res;
            _authorsOfBook.forEach(author => {
                onAddAuthorToBook(author);
            })
        })
    }
    fetchAuthor().then(res => _allAuthor = res);

}
main();




