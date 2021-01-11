

async function deleteBookAJAX(path, bookId){

    const chose = confirm("Are you sure to delete this?")
    if(chose){
        const resFetch = await fetch(`${path}book_action?id=${bookId}`, {method:"delete"})
        const res = await resFetch.json();
        if(res.status === "success"){
            //delete success
            const tableBody = document.getElementById("table--body");
            let childNodes= [...tableBody.children]
            let deletedElement = childNodes.find(ele => ele.id == bookId);
            deletedElement.remove();
        }else{
            // show error
        }
    }{
        //cancel delete
    }
}



