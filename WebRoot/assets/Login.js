
var userInput = {                   //储存用户输入的表单
    username: '',                   //用户名
    password: ''                    //密码
}

//获取用户名
var usernameInput = document.getElementById('usernameInput');
usernameInput.onblur = function (){
    if(!/(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/i.test(usernameInput.value)){
        document.getElementById('check-phoneNumber').className = 'show';
        return;
    }
    document.getElementById('check-phoneNumber').className = 'hidden';
    userInput.username = usernameInput.value;
}
//获取密码
var passwordInput = document.getElementById('passwordInput');

passwordInput.onblur = function (){
    userInput.password = passwordInput.value;
}

//提交
var submit = document.getElementById('submit');
//var url = 'http://111.230.236.54:8080/ErXueSSM'; 
//var url = 'http://localhost:8080/ErXueSSM'; 

var login;
submit.onclick = function (){
    if(!userInput.username){
        alert('请输入用户名！');
        return;
    }
    if(!userInput.password){
        alert('请输入密码！');
        return;
    }
    $.ajax({
        type: 'post',
        url: url + '/login.action',
        data: userInput,
        dataType: 'text',
//        contentType:"application/json",
        success: function (data){
            if(data==="false"){
                document.getElementById('check-password').className = 'show';
                return;
            }else{
            	document.getElementById('check-password').className = 'hidden';  
            	window.location.href="widget.html";
            }      
        }
    })
}

