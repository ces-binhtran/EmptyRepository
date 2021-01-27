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
const rootAPI = "http://localhost:8080/api";


// ---------------------Event-----------------------

window.addEventListener("click", (event) => {
    if(event.target !== inputSearch && event.target !== authorListSearchEle ){
        inputSearch.value = ""
        clearChild()
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
    clearChild();
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


async function createBook(){

    const resultJson = await fetch(`${rootAPI}/book`, {
        method: "post",
        body: {
            name : nameInput.value,
            type : typeSelect.value
        }
    })
    return await  resultJson.json();
}

async function addAuthorToBook(bookId, authorId){
    const resultJson = await fetch(`${rootAPI}/book`, {
        me
    })
}
//-----------------------Other---------------------



function clearChild() {
    while (authorListSearchEle.lastElementChild) {
        authorListSearchEle.removeChild(authorListSearchEle.lastElementChild);
    }
}


function renderSelectBox(data){
    clearChild();
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
    fetchAuthor().then(res => _allAuthor = res);
}
main();




