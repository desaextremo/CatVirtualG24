//definicion de variables
let new_category = document.getElementById("new_category")
let save_category = document.getElementById("save_category")
let delete_category = document.getElementById("delete_category")
let list_category = document.getElementById("list_category")
let insert_category = document.getElementById("insert_category")

//Escuchas de eventos
insert_category.addEventListener("click", new_)

function initial() {
  new_category.style.display = "none"
  save_category.style.display = "none"
  delete_category.style.display = "none"
  list_category.style.display = "block"

  load_data()
}

function new_() {
  new_category.style.display = "block"
  save_category.style.display = "none"
  delete_category.style.display = "none"
  list_category.style.display = "none"
}

function edit_() {
  new_category.style.display = "none"
  save_category.style.display = "block"
  delete_category.style.display = "none"
  list_category.style.display = "none"
}

function delete_() {
  new_category.style.display = "none"
  save_category.style.display = "none"
  delete_category.style.display = "block"
  list_category.style.display = "none"
}

function load_data(){
  //Defino el objeto
  let objAajax = new XMLHttpRequest()
  
  //configuro la peticion
  objAajax.open("GET","http://localhost:8084/api/category/all")

  //controlar la respuesta
  objAajax.addEventListener('load', data =>{
    const dataJson = JSON.parse(data.target.response) 
    let registros= ""
    console.log(dataJson)

    //recorre respuesta y va recuperando datos
    
    for (let i in dataJson) {
      registros += "<tr>" +
                    "<td>" + dataJson[i].id + "</td>" +
                    "<td>" + dataJson[i].name + "</td>" +
                    "<td colspan='2'>" +
                    "  <button onclick=''>Editar</button>" +
                    "  <button onclick=''>Eliminar</button>" +
                    "</td>" +
                    "</tr>";
    }
    document.getElementById("table_body").innerHTML=registros
});
  //envio la petion
  objAajax.send()
}

initial()