const fileResult = document.getElementById("fileResult");
const fileAdd =document.getElementById("fileAdd");
const del = document.getElementsByClassName("del");

let count =0;
let num=0;  // id용도

fileAdd.addEventListener("click",function(){
    count=count+1;
    //count++;

    if(count>5){
        alert("첨부파일은 최대 5개까지 가능합니다");
        //count=5;
        count--;
        return;
    }

    //count++ 를 여기에 두고 if 조건문에서 count를 count>4 이렇게 하는 방법도 있음 

    let div= document.createElement("div");  //<div></div>
    div.setAttribute("id","del"+num)
    
    let file=document.createElement("input"); //<input></input>
    file.setAttribute("type","file");  //<input type="file"></input>
    file.setAttribute("name","files");  //<input type="file" name="files"></input>
    
    
    let button=document.createElement("button");
    button.setAttribute("type","button");
    button.className="del";
    button.setAttribute("data-num","del"+num);
    button.innerHTML="DEL";
    
    div.append(file);
    div.append(button);
    
    fileResult.append(div);
    
    num++;

});


fileResult.addEventListener("click",function(event){
    let cn =event.target;

    // console.log(event.target.classList.contains('del'));
    
    if(cn.classList.contains("del")){
        let delNum=cn.getAttribute("data-num");
        document.getElementById(delNum).remove();
        count--;
    }

});
