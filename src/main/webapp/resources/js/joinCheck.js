/**
 * 
 */
console.log("join check");
const checkAll=document.getElementById('checkAll');
const check=document.getElementsByClassName('check');
const rule=document.getElementsByClassName('rule');

checkAll.addEventListener("click",function(){
    
    for(agree of check){
        agree.checked=checkAll.checked;
    }

})

for(ch of check){
    ch.addEventListener("click",function(){
        console.log(this.checked);
    

    })
}

// for(ch of check){
//     ch.addEventListener("click",function(){
//         let final=true;

//         for(c of check){
//             if(!c.checked){
//                 final=false;
//             }
//         }
//         checkAll.checked=final;
//     })
// }