var url='http://111.230.236.54:8080'; 
//var url='http://192.168.0.110:8080'; 
//设置Ajax请求的全局默认options
$.ajaxSetup({
  type:'post',
     // 请求完成后的回调函数,无论成功与否。textStatus为一个描述请求类型的字符串，
      //  它可以有以下值success，notmodified，error，timeout，abort，parsererror 
   complete:function(xhr, ts){ //XMLHttpRequest, textStatus
      var sessionStatus = xhr.getResponseHeader('sessionStatus');
      if(sessionStatus == 'timeout') {
          alert('您还没有登陆，请登陆后重新访问！');
          window.top.location.href = 'Login.html';
      }else if(sessionStatus=='noAuthority'){
    	  alert( "您的次数已经使用完了，如需查看更多请咨询管理员!");
    	  return;
      }
  }
});