const fileResult = document.getElementById("fileResult");
const fileAdd =document.getElementById("fileAdd");

let count =0;

fileAdd.addEventListener("click",function(){
    count=count+1;
    //count++;
    if(count>5){
        alert("첨부파일은 최대 5개까지 가능합니다");
        return;
    }

    let del= document.createElement("div");  //<div></div>

    let file=document.createElement("input"); //<input></input>
    file.setAttribute("type","file");  //<input type="file"></input>
    file.setAttribute("name","files");  //<input type="file" name="files"></input>
    
    
    let button=document.createElement("button");
    button.setAttribute("type","button");
    button.innerHTML="DEL";
    
    del.append(file);
    del.append(button);
    fileResult.append(del);
});

