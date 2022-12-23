let consulta_boton = document.getElementById("consulta")
let lista_categoria = document.getElementById("lista_categoria")
let table_body = document.getElementById("table_body")
let salida = ""

//escuchas de eventos
consulta_boton.addEventListener("click", query_books_category)

function load_category_list() {
    axios.get('http://localhost:8084/api/category/all')
        .then(function (response) {
            //acceder a la lista x su id
            for (let i in response.data) {
                salida += `<option value="${response.data[i].id}">${response.data[i].name}</option>`
            }
            lista_categoria.innerHTML = salida
        })
        .catch(function (error) {
            //Error - manejar error
            alert(error)
        })

}
/**
 * invoca ws //http://localhost:8084/api/book/category/{categoria id}
 * en donde categoria id coincide con el valor seleccionado de la lista desplegable
 */
function query_books_category() {
    //obtener le id de la categoria seleccionada
    let id_categoria = lista_categoria.value
    salida=""

    axios.get('http://localhost:8084/api/book/category/' + id_categoria)
        .then(function (response) {           
            for (let i in response.data) {
                salida += `<tr>
                            <td>${response.data[i].isbn}</td>
                            <td>${response.data[i].category.name}</td>
                            <td>${response.data[i].title}</td>
                            <td>${response.data[i].author.fisrtName} ${response.data[i].author.lastName}</td>
                            <td>${response.data[i].pages}</td>
                            <td>${response.data[i].price}</td>
                            <td>${response.data[i].year}</td>
                            </tr>`
            }
            table_body.innerHTML = salida
        })
        .catch(function (error) {
            //Error - manejar error
            alert(error)
        })
}




load_category_list()