let consulta_boton = document.getElementById("consulta")
let lista_autores = document.getElementById("lista_autores")
let table_body = document.getElementById("table_body")
let salida = ""

//escuchas de eventos
consulta_boton.addEventListener("click", query_books_author)

function load_author_list() {
    axios.get('http://localhost:8084/api/author/all')
        .then(function (response) {
            //acceder a la lista x su id
            for (let i in response.data) {
                salida += `<option value="${response.data[i].id}">${response.data[i].fisrtName} ${response.data[i].lastName}</option>`
            }
            lista_autores.innerHTML = salida
        })
        .catch(function (error) {
            //Error - manejar error
            alert(error)
        })

}
/**
 * invoca ws //http://localhost:8084/api/book/author/{author id}
 * en donde categoria id coincide con el valor seleccionado de la lista desplegable
 */
function query_books_author() {
    //obtener le id del autor seleccionado
    let id_author = lista_autores.value
    salida=""

    axios.get('http://localhost:8084/api/book/author/' + id_author)
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




load_author_list()