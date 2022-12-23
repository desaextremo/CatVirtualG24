let consulta_boton = document.getElementById("consulta")
let lista_letras = document.getElementById("lista_letras")
let table_body = document.getElementById("table_body")
let salida = ""

//escuchas de eventos
consulta_boton.addEventListener("click", query_books_letter)

function load_letter_list() {
    const alphabet = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];

    for (let i in alphabet){
        salida += `<option value="${alphabet[i]}">${alphabet[i]}</option>`
    }

    lista_letras.innerHTML = salida
}
/**
 * invoca ws //http://localhost:8084/api/book/ind/{letter}
 * en donde letter coincide con el valor seleccionado de la lista desplegable
 */
function query_books_letter() {
    //obtener le id del autor seleccionado
    let letter_selected = lista_letras.value
    salida=""

    axios.get('http://localhost:8084/api/book/ind/' + letter_selected)
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

load_letter_list()