function criarCatalogo() {

    var invocation = new XMLHttpRequest();

    var url = "http://ruthzil.com.br/catalogo";

    var catalogo = {
        'nome': document.getElementById("txtNome").value,
        'descricao': document.getElementById("txtDesc").value,
        'categoria': document.getElementById("txtCategoria").value,
        'path': document.getElementById("txtPath").value
    };

    var envelope = {
        method: "POST",
        body: JSON.stringify(catalogo),
        headers: {
            "Content-type": "application/json"
        }
    };

    fetch(url, envelope)
        .then(res => res.json())
        .then(res => {
            var catalogoCriado = res;
            alert("Usuário criado com sucesso. ID gerado = " + catalogoCriado.id);
            window.location = "catalogo.html";
        }
        )
        .catch(err => {
            alert("Erro ao criar catalogo");
            console.log(err);
        });

}

function carregarListaCatalogo() {

    var url = "http://localhost:8080/catalogo";

    fetch(url)
        .then(res => res.json())
        .then(res => {
            montarGrid(res);
        }
        )
        .catch(err => {
            alert("Erro ao carregar listagem de usuários");
            console.log(err);
        });

}

function montarGrid(listaCatalogo) {

    var tabela =
        "<table class='table table-striped'>" +
        "<thead>" +
        "<tr>" +
        "<th scope='col'>Nome do Catálogo</th>" +
        "<th scope='col'>Descrição</th>" +
	"<th scope='col'>Categoria</th>" +
        "<th scope='col'>Arquivo</th>" +
        "</tr>" +
        "</thead>" +
        "<tbody>";

    for (cont = 0; cont < listaCatalogo.length; cont++) {
        var catalogo = listaCatalogo[cont];
        tabela +=
            "<tr>" +
            "<td>" + catalogo.nome + "</td>" +
            "<td>" + catalogo.descricao + "</td>" +
	    "<td>" + catalogo.cat + "</td>" +
            "<td><a href=" + catalogo.path + "> Download</td>" +
            "</tr>";
    }

    tabela += "</tbody></table>";

    document.getElementById("divDados").innerHTML = tabela;

}