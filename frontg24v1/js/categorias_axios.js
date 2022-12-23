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
cancel_new.addEventListener("click", initial)
cancel_delete.addEventListener("click", initial)
ok_new.addEventListener("click", new_save)
ok_save.addEventListener("click", save)
ok_delete.addEventListener("click", delete_save)

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
  document.getElementById("name_new").value = ""
  document.getElementById("name_new").focus()
}

/**
 * Recibe los datos que ingresa el usuario, configura la información en formato JSON
 * y realiza el consumo de WS: http://localhost:8084/api/category/new
 */
function new_save() {
  //Obtiene la información registrada por el usuario
  let name_new = document.getElementById("name_new").value

  axios.post('http://localhost:8084/api/category/new', {
    name: name_new
  }
  ).then(function (response) {
    console.log(response)
    console.log(response.data)
    initial()
  })
    .catch(function (error) {
      //Error - manejar error
      alert(error)
    })
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


  axios.get('http://localhost:8084/api/category/' + id)
    .then(function (response) {
      let dataJson = response.data
      //Obtiene la información registrada por el usuario
      id_save.value = dataJson.id
      name_save.value = dataJson.name
    })
    .catch(function (error) {
      //Error - manejar error
      alert(error)
    })

}

/**
 * Obtiene los datos ingresados en las cajas de texto
 * Crear un objeto javascript/json
 * Invocar al ws: http://localhost:8084/api/category/save
 */
function save() {
  //Obtiene la información registrada por el usuario
  let id_save = document.getElementById("id_save").value
  let name_save = document.getElementById("name_save").value

  axios.put('http://localhost:8084/api/category/save',
    {
      id: id_save,
      name: name_save
    })
    .then(function (response) {
      console.log(response.data)
      initial()
    })
    .catch(function (error) {
      //Error - manejar error
      alert(error)
    })
}

function delete_(id) {
  new_category.style.display = "none"
  save_category.style.display = "none"
  delete_category.style.display = "block"
  list_category.style.display = "none"
  let list_delete = document.getElementById("list_delete")

  axios.get('http://localhost:8084/api/category/' + id)
    .then(function (response) {
      let salida = ""
      //Obtiene la información registrada por el usuario
      salida += `<li><strong>Id :</strong>${response.data.id}</li>
               <li><strong>Categoría :</strong>${response.data.name}</li>`

      list_delete.innerHTML = salida

      document.getElementById("id_delete").value = response.data.id
    })
    .catch(function (error) {
      //Error - manejar error
      alert(error)
    })
}

function delete_save() {
  //obtengo el id
  let id_delete = document.getElementById("id_delete").value

  axios.delete('http://localhost:8084/api/category/' + id_delete)
    .then(function (response) {
      initial()
    })
    .catch(function (error) {
      //Error - manejar error
      alert(error)
    })
}

/**
 * Obtiene los datos de la coleccion genders (categorias), 
 * invoca al ws: http://localhost:8084/api/category/all
 */
function load_data() {
  axios.get('http://localhost:8084/api/category/all')
    .then(function (response) {
      dataJson = response.data
      let registros = ""
      //respuesta exitosa - response.data
      for (let i in dataJson) {
        registros += `<tr>
                    <td>${dataJson[i].name}</td>
                    <td colspan='2'>
                      <button onclick="edit_('${dataJson[i].id}')">Editar</button>
                      <button onclick="delete_('${dataJson[i].id}')">Eliminar</button>
                    </td>
                    </tr>`
      }

      document.getElementById("table_body").innerHTML = registros
    })
    .catch(function (error) {
      console.log(error.message)
      //Error - manejar error
      alert(error.message)
    })
    .then(function () {
      //siempre se va a ejecutar

    });
}

initial()