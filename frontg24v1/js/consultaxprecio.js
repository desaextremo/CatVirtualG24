let consulta_boton = document.getElementById("consulta")
let liminf = document.getElementById("liminf")
let limsup = document.getElementById("limsup")
let table_body = document.getElementById("table_body")
let salida = ""

liminf.focus()
//escuchas de eventos
consulta_boton.addEventListener("click", query_books_price)

/**
 * invoca ws //http://localhost:8084/api/book/ind/{letter}
 * en donde letter coincide con el valor seleccionado de la lista desplegable
 */
function query_books_price() {
    //obtener el valor del  rango de precios
    let liminf_val = liminf.value
    let limsup_val = limsup.value
    salida=""

    axios.get('http://localhost:8084/api/book/price/' + liminf_val + "/" + limsup_val)
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