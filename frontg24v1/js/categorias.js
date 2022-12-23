//definicion de variables
let new_category = document.getElementById("new_category")
let save_category = document.getElementById("save_category")
let delete_category = document.getElementById("delete_category")
let list_category = document.getElementById("list_category")
let insert_category = document.getElementById("insert_category")
let cancel_new = document.getElementById("cancel_new")
let ok_new = document.getElementById("ok_new")
let ok_save = document.getElementById("ok_save")
let cancel_delete = document.getElementById("cancel_delete")
let ok_delete = document.getElementById("ok_delete")


//Escuchas de eventos
insert_category.addEventListener("click", new_)
cancel_new.addEventListener("click",initial)
cancel_delete.addEventListener("click",initial)
ok_new.addEventListener("click",new_save)
ok_save.addEventListener("click",save)
ok_delete.addEventListener("click",delete_save)

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
  document.getElementById("name_new").focus()
}

/**
 * Recibe los datos que ingresa el usuario, configura la información en formato JSON
 * y realiza el consumo de WS: http://localhost:8084/api/category/new
 */
function new_save(){
  //Obtiene la información registrada por el usuario
  let name_new = document.getElementById("name_new").value

  //configura información en formato de objeto javascript
  let objetoJS = {
    name: name_new
  }

  //Convierto objeto de javascript a json, antes de enviarlo(de realizar la petición)
  let objetoJson = JSON.stringify(objetoJS)

  //1 Crear objeto XMLHttpRequest
  let objAajax = new XMLHttpRequest()

  //configurar la petición
  objAajax.open("POST","http://localhost:8084/api/category/new")
  objAajax.setRequestHeader("Content-Type", "application/json;charset=UTF-8")

  //controlar el momento en el que el servidor envie la respuesta
  objAajax.addEventListener("load",data => {
    let response = JSON.parse(data.target.response)
    console.log(data)
    console.log(response)
    initial()
  })
  //enviar la peticion
  objAajax.send(objetoJson)
}

/**
 * configura el aspecto de la pagina
 * Invoca al ws: http://localhost:8084/api/book/un id de categoria
 * agrega los datos en el los campos de tipo input
*/
function edit_(id) {
  //configura el aspecto de la pagina
  new_category.style.display = "none"
  save_category.style.display = "block"
  delete_category.style.display = "none"
  list_category.style.display = "none"
  
  let id_save = document.getElementById("id_save")
  let name_save = document.getElementById("name_save")

  //invoca al ws: http://localhost:8084/api/book/un id de categoria
  //Defino el objeto
  let objAajax = new XMLHttpRequest()
  
  //configuro la peticion
  objAajax.open("GET","http://localhost:8084/api/category/" + id)

  //controlar la respuesta
  objAajax.addEventListener('load', data =>{
    //obtengo los datos de la respuesta
    const dataJson = JSON.parse(data.target.response) 
    console.log(dataJson)
    //Obtiene la información registrada por el usuario
    id_save.value = dataJson.id
    name_save.value = dataJson.name

    //Adiciona los datos obtenido desde el servicio a cada uno de los elementos input

  })

  //envio la peticion
  objAajax.send()

}

/**
 * Obtiene los datos ingresados en las cajas de texto
 * Crear un objeto javascript/json
 * Invocar al ws: http://localhost:8084/api/category/save
 */
function save(){
  //Obtiene la información registrada por el usuario
  let id_save = document.getElementById("id_save").value
  let name_save = document.getElementById("name_save").value

  //Creo objeto JS
  //configura información en formato de objeto javascript
  let objetoJS = {
    id:id_save,
    name: name_save
  }

  //Convierto objeto de javascript a json, antes de enviarlo(de realizar la petición)
  let objetoJson = JSON.stringify(objetoJS)

  //1 Crear objeto XMLHttpRequest
  let objAajax = new XMLHttpRequest()

  //configurar la petición
  objAajax.open("PUT","http://localhost:8084/api/category/save")
  objAajax.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
  //Controlar la respusta
  objAajax.addEventListener("load",data=>{
    let response = JSON.parse(data.target.response)
    console.log(data)
    console.log(response)
    initial()  
  })
  //Enviar la petición
  objAajax.send(objetoJson)
}

function delete_(id) {
  new_category.style.display = "none"
  save_category.style.display = "none"
  delete_category.style.display = "block"
  list_category.style.display = "none"
  let list_delete = document.getElementById("list_delete")

  //invoca al ws: http://localhost:8084/api/book/un id de categoria
  //Defino el objeto
  let objAajax = new XMLHttpRequest()
  let salida=""
  //configuro la peticion
  objAajax.open("GET","http://localhost:8084/api/category/" + id)

  //controlar la respuesta
  objAajax.addEventListener('load', data =>{
    //obtengo los datos de la respuesta
    const dataJson = JSON.parse(data.target.response) 
    console.log(dataJson)

    //Obtiene la información registrada por el usuario
    salida += `<li><strong>Id :</strong>${dataJson.id}</li>
               <li><strong>Categoría :</strong>${dataJson.name}</li>`

    list_delete.innerHTML = salida

    document.getElementById("id_delete").value = dataJson.id
  })
  
  objAajax.send()
}

function delete_save (){
  //obtengo el id
  let id_delete = document.getElementById("id_delete").value

  //Defino el objeto
  let objAajax = new XMLHttpRequest()
  
  //configuro la peticion
  objAajax.open("DELETE","http://localhost:8084/api/category/" +id_delete)
  objAajax.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
  //controlar la respuesta
  objAajax.addEventListener('load', data =>{
    
    initial()
  })

  objAajax.send()
}
/**
 * Obtiene los datos de la coleccion genders (categorias), 
 * invoca al ws: http://localhost:8084/api/category/all
 */
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
      /*
      registros += "<tr>" +
                    "<td>" + dataJson[i].id + "</td>" +
                    "<td>" + dataJson[i].name + "</td>" +
                    "<td colspan='2'>" +
                    "  <button onclick=''>Editar</button>" +
                    "  <button onclick=''>Eliminar</button>" +
                    "</td>" +
                    "</tr>";
      */
       registros += `<tr>
                    <td>${dataJson[i].name}</td>
                    <td colspan='2'>
                      <button onclick="edit_('${dataJson[i].id}')">Editar</button>
                      <button onclick="delete_('${dataJson[i].id}')">Eliminar</button>
                    </td>
                    </tr>`        
    }
    document.getElementById("table_body").innerHTML=registros
});
  //envio la petion
  objAajax.send()
}

initial()