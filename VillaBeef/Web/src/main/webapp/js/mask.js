const input = document.getElementById("cpf");

input.addEventListener("keyup", formatarCPF);

function formatarCPF(e){

    var v=e.target.value.replace(/\D/g,"");
    v=v.replace(/(\d{3})(\d)/,"$1.$2");
    v=v.replace(/(\d{3})(\d)/,"$1.$2");
    v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2");
    e.target.value = v;

} 

const input2 = document.getElementById("salario");
const input3 = document.getElementById("valor");

input2.addEventListener("change", formatarMoeda); 
input3.addEventListener("change", formatarMoeda); 

function formatarMoeda(e) {

    var v = e.target.value.replace(/\D/g,"");
    v = (v/100).toFixed(2) + "";
    v = v.replace(",", ".");
    v = v.replace(/(\d)(\d{3})(\d{3}),/g, "$1.$2.$3,");
    v = v.replace(/(\d)(\d{3}),/g, "$1.$2,");
    e.target.value = v;

}
