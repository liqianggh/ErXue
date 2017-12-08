//储存用户信息
var user = {
    username: '',        //电话
    password: '',           //密码
}
var verifyCode;         //验证码
//var url = 'http://192.168.0.110:8080/ErXueSSM';
var url = 'http://111.230.236.54:8080/ErXueSSM'

//验证用户名
// var username = document.getElementById('username');
// username.onchange = function(){    
//     if(!/^[a-zA-Z\d]+$/i.test(username.value)){
//         document.getElementById('check-username').className = 'show';
//         return;
//     }
//     document.getElementById('check-username').className = 'hidden';
//     user.username = username.value;
//     $.ajax({
//         type: 'post',
//         url: url + '/checkUsername.action',
//         data: user.username,    
//         success: function (data){            
//             if(!data){
//                 alert('该用户名已注册！'); 
//                 return;
//             }
//         }
//     });
    
// }
//验证电话号码格式
var phoneNumber = document.getElementById('phoneNumber');
var phone;
phoneNumber.onblur = function(){
    if(!/(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/i.test(phoneNumber.value)){
        document.getElementById('check-phoneNumber').className = 'show';
        return;
    }
    document.getElementById('check-phoneNumber').className = 'hidden';
    phone = phoneNumber.value;
    console.log(phone);
    user.username = phone;
}

phoneNumber.onchange = function(){  
$.ajax({
  type: 'post',
  url: url + '/checkUsername.action',
  contentType:'application/json',
  data: { username:phoneNumber.value},    
  async: false,  
  xhrFields: {  
      withCredentials: true  
  },  
  success: function (data){   
      if(!data){
          alert('该用户名已注册！'); 
          return;
      }
  }
});
}



//获取验证码
var getVerificationCode = document.getElementById('getVerificationCode');

getVerificationCode.onclick = function(){
    if(!phone){
        document.getElementById('check-phoneNumber').className = 'show';
        return;
    }
    
    $.ajax({
        type:"post",
        url: url+"/sendMessageVerifyCode.action",
        data: {username:phone},
        dataType:"text",
        async: false,  
        xhrFields: {  
            withCredentials: true  
        },  
        success: function (data) {
            console.log(data);
        }
    });
}
//验证密码（第一次）
var passwdfirst = document.getElementById("passwdfirst");
var passwd;
passwdfirst.onblur = function(){
    if(!passwdfirst.value){
        document.getElementById('check-passwdfirst').className = 'show';
        return;
    }
    if(!/^[0-9a-zA-Z]{6,16}$/i.test(passwdfirst.value)){
        alert("请输入6位数字或字母");
    }
    document.getElementById('check-passwdfirst').className = 'hidden';
    passwd = passwdfirst.value;
}
//验证密码（第二次）
var passwdsecond = document.getElementById("passwdsecond");

passwdsecond.onblur = function(){
    if(passwdsecond.value !== passwd){
        document.getElementById('check-passwdsecond').className = 'show';
        return;
    }
    document.getElementById('check-passwdsecond').className = 'hidden';
    user.password = passwd;
}

//验证码表单是否填写
var VerificationCodeInput = document.getElementById('VerificationCodeInput');

VerificationCodeInput.onchange = function(){
    if(!VerificationCodeInput.value){
        document.getElementById('check-VerificationCodeInput').className = 'show';
        document.getElementById('check-VerificationCodeInputError').className = 'hidden';
        return
    }
    document.getElementById('check-VerificationCodeInput').className = 'hidden';    
    code = VerificationCodeInput.value;
    $.ajax({
        type: 'post',
        url: url+"/checkout.action",
        data: {verifyCode:code},
        dataType: "text",
//         contentType: "application/json",
         async: false,  
         xhrFields: {  
             withCredentials: true  
         },  
        success: function (data) {
            if(!Boolean(data)){
                document.getElementById('check-VerificationCodeInputError').className = 'show';
                return;
            }
            document.getElementById('check-VerificationCodeInputError').className = 'hidden';
        }
    });
}

//提交
var submit = document.getElementById('submit');
submit.onclick = function(){
//    var url = 'http://111.230.236.54:8080/ErXueSSM'

    if(!VerificationCodeInput.value){
        document.getElementById('check-VerificationCodeInput').className = 'show';
        return;
    }
    if(!(user.username&&user.password)){
        alert("请补全必填项");
        return;
    }
    if(!/^[0-9a-zA-Z]{6,16}$/i.test(user.password)){
        alert('请输入6位数字或字母作为密码');
        return;   
    }
    if(passwdfirst.value!==passwdsecond.value){
        alert('请保证两次密码一致');
        return;        
    }
    console.log(user);
    $.ajax({
        type: 'post',
        url: url+"/regist.action",
        data: JSON.stringify(user),
        dataType:"text",
        async: false,  
        xhrFields: {  
            withCredentials: true  
        },  
         contentType: "application/json",
        success: function (data) {
            if(data){
            	alert("注册成功！");
            	 window.location.href="Login.html";
            }else{
            	alert("注册失败！");
            }
        }
    })
}
