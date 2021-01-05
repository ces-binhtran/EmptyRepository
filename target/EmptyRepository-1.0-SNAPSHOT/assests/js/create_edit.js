const inputName = document.getElementById("name");
const inputAuthor = document.getElementById("author")
const submitButton = document.getElementById("submit");
const nameError = document.getElementById("form-error");


function validate(){
  const nameValue = inputName.value;
  if(nameValue){

    return true;
  }
  nameError.innerHTML = "Name can't empty"
  return false;
}