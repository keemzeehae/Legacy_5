/**
 * 
 */
console.log("join check");
const checkAll=document.getElementById('checkAll');
const check=document.getElementsByClassName('check');
const rule=document.getElementsByClassName('rule');
const btn = document.getElementById('btn');
checkAll.addEventListener("click",function(){
    
    for(agree of check){
        agree.checked=checkAll.checked;
    }

});

// for(ch of check){
//     ch.addEventListener("click",function(){
//         console.log(this.checked);
    

//     })
// }

for(ch of check){
    ch.addEventListener("click",function(){
        let final=true;

        for(c of check){
            if(!c.checked){
                final=false;
            }
        }
        checkAll.checked=final;
    })
};

btn.addEventListener("click",function(){
    // let c= true;
    // for(ch of check){
    //     if(!ch.checked){
    //         c=false;
    //     }
    // }
    //if(check[0].checked&&check[1].checked&&check[2].checked&&check[3].checked){
    if(checkAll.checked){
    location.href="./join";
    }else{
        alert('약관에 동의가 필요합니다');
    }
})