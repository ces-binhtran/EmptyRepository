
const inputName = document.getElementById("name");
const inputType = document.getElementById("type");
const nameError = document.getElementById("form-error");
const authorList = document.getElementById("author--list")
const form = document.getElementById("form");
const authorSelect = document.getElementById("author")
//edit mode
const bookId = getQueryString("bookId");

let _authorsOfBook = [];
let _authors = [];
let currentAuthors = [];

function validate(){

  const nameValue = inputName.value;
  if(nameValue){
    return true;
  }
  nameError.innerHTML = "Name can't empty"
  return false;
}
async function onSubmitHandler()
{

  const nameInput = inputName.value;
  const typeInput = inputType.value;

  const rootURL = `${getContextPath()}`
  const data = {
    name: nameInput,
    type: typeInput
  }
  const valid = validate();
  if(valid){
    //send ajax

    const config = {
      method : "post",
      body: JSON.stringify(data)
    }
    if(bookId){
      //edit mode -> update book
      const jsonRes = await fetch(`${rootURL}/Book_ajax?bookId=${bookId}`, config);

      const addedAuthor = currentAuthors.filter(ele => !_authorsOfBook.some(e => e.id == ele.id));
      const deletedAuthor = _authorsOfBook.filter(ele => !currentAuthors.some(e => e.id == ele.id));


      Promise.all(
          [
              ...addedAuthor.map(ele =>
              fetch(`${rootURL}/Author_ajax/add_author_to_book?authorId=${ele.id}&bookId=${bookId}`, {method: "post"})),
              ...deletedAuthor.map(ele =>
                  fetch(`${rootURL}/Author_ajax//delete_author_from_book?authorId=${ele.id}&bookId=${bookId}`, {method: "post"})),
    ]).then(res => location.href = (`${rootURL}/Book`))
    }else{
      // create mode -> create book
      const resJSON = await fetch(`${rootURL}/Book_ajax`, config)
      const res = await resJSON.json();

      const newBookId = res.id;
      Promise.all(currentAuthors
          .map(ele =>
              fetch(`${rootURL}/Author_ajax/add_author_to_book?authorId=${ele.id}&bookId=${newBookId}`, {method: "post"})))
          .then(res => location.href = (`${rootURL}/Book`))

    }
  }
  return valid
}






function deleteAuthorOfBook(authorId){
  const childNodes = [...authorList.children]
  const deletedElement = childNodes.find(ele => ele.id == authorId);
  deletedElement.remove();

  currentAuthors = currentAuthors.filter(ele => ele.id != authorId);
  renderOption();
}

function addAuthorForBook(){
  const selectedItem = authorSelect.options[authorSelect.selectedIndex];
  currentAuthors.push({id : selectedItem.id, name : authorSelect.value});

  renderAuthors()
  renderOption()
}

function renderAuthors (){
  authorList.innerHTML ="";
  currentAuthors.forEach(ele => {
    authorList.insertAdjacentHTML("beforeend", `
    <div class="author--item" id="${ele.id}">
        <input  type="text" name="authorOfBook" readonly value="${ele.name}">
        <button type="button" onclick="deleteAuthorOfBook( ${ele.id}, ${bookId})">Delete</button>
    </div>
  `)
  })
}

function renderOption(){

  authorSelect.innerHTML = "";
  const temp = _authors.filter(ele => !currentAuthors.some(e => ele.id == e.id));
  // console.log(_authors, currentAuthors, temp)
  authorSelect.insertAdjacentHTML("beforeend", "<option>Unknown</option>")
  temp.forEach(ele => {
    authorSelect.insertAdjacentHTML("beforeend",`
     <option id="${ele.id}">${ele.name}</option>
    `)
  })
}


async function fetchAllAuthorOfBook(){
  const path = `${getContextPath()}/Author_ajax`;
  if(bookId) {
    //edit mode
    const jsonRes = await fetch(`${path}/authors_of_book?bookId=${bookId}`);
    _authorsOfBook = await jsonRes.json();
    currentAuthors = [..._authorsOfBook];

  }
}


async function fetchAllAuthor(){
  const path = `${getContextPath()}/Author_ajax`;
  const jsonRes = await fetch(`${path}/all_author`);
  _authors = await jsonRes.json();
}

function getContextPath(){
  return document.getElementById("global--context_path").getAttribute("value");
}

function getQueryString(paramName){
  let url = new URL(window.location.href);
  return url.searchParams.get(paramName);
}

function main(){
  console.log("Test")
  Promise.all([fetchAllAuthor(), fetchAllAuthorOfBook()]).then(res => renderOption())
}

main()


